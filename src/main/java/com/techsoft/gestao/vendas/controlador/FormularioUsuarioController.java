/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.controlador;

import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import com.techsoft.gestao.vendas.modelo.servico.PermissaoServico;
import com.techsoft.gestao.vendas.modelo.servico.UsuarioServico;
import com.techsoft.gestao.vendas.visao.formulario.FormularioUsuario;
import com.techsoft.gestao.vendas.visao.modelo.TabelaModeloUsuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class FormularioUsuarioController implements ActionListener, MouseListener {
    private FormularioUsuario formularioUsuario;
    private UsuarioServico usuarioServico;
    private PermissaoServico permissaoServico;
    private TabelaModeloUsuario tabelaModeloUsuario;
    private List<Usuario> usuarios;
    private String urlFoto;
    private Long atualizarUsuario;
    private Long usuarioLogado;
    private Usuario usuario;
    
    private final long PERMISSAO_ID_PARA_SALVAR_USUARIO = 1;
    private final long PERMISSAO_ID_PARA_SOMENTE_SEU = 2;
    private final long PERMISSAO_ID_BUSCAR_TODOS = 3;
    private final long PERMISSAO_ID_REMOVER = 4;

    public FormularioUsuarioController(FormularioUsuario formularioUsuario) {
        this.formularioUsuario = formularioUsuario;
        usuarioServico = new UsuarioServico();
        permissaoServico = new PermissaoServico();
        this.usuarioLogado = formularioUsuario.getUsuarioId();
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        usuarios = usuarioServico.buscarTodos();
        tabelaModeloUsuario = new TabelaModeloUsuario(usuarios);
        formularioUsuario.getTabelaUsuario().setModel(tabelaModeloUsuario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        System.out.println(acao);
        switch (acao) {
            case "adicionar" -> { mostrarTela("ADICIONAR USUARIO"); }
            case "atualizar" -> { atualizarTela("ATUALIZAR USUARIO"); }
            case "salvar" -> { salvarUsuario(); }
            case "selecionar" -> { escolherArquivo(); }
            case "remover" -> { remover(); }
        }
    }
    
    private void mostrarTela(String titulo) {
        permissaoServico.validarPermissao(PERMISSAO_ID_PARA_SALVAR_USUARIO, usuarioLogado);
        limparCamposUsuario();
        limparMensagem();
        formularioUsuario.getDialogUsuario().pack();
        formularioUsuario.getDialogUsuario().setLocationRelativeTo(null);
        formularioUsuario.getDialogUsuario().setVisible(true);
        formularioUsuario.getLabelTitulo().setText(titulo);
    }
    
    private void atualizarTela(String titulo) {
        if (usuario == null) {
            String mensagem = "Deve selecionar o usuario na tabela";
            JOptionPane.showMessageDialog(null, mensagem, "Selecione a tabela", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(mensagem);
        }
        
        limparMensagem();
        formularioUsuario.getDialogUsuario().pack();
        formularioUsuario.getDialogUsuario().setLocationRelativeTo(null);
        formularioUsuario.getDialogUsuario().setVisible(true);
        formularioUsuario.getLabelTitulo().setText(titulo);
        preencherFormularioDeCadastro(usuario);
        
    }
    
    private void validacaoTexto(String texto) {
        if (texto == null || texto.isBlank()) {
            String mensagem = "Todos os campos são obrigatorios";
            mensagem(false, mensagem);
            throw new RuntimeException(mensagem);
        }
    }
    
    private void validacaoPerfil() {
        if (formularioUsuario.getComboPerfil().getSelectedIndex() < 1) {
            String mensagem = "É obrigatorio selecionar o perfil";
            mensagem(false, mensagem);
            throw new RuntimeException(mensagem);
        }
    }
    
    private void mensagem(boolean bool, String mensagem) {
        if (bool) {
            formularioUsuario.getLabelMensagem().setBackground(Color.decode("#45B649"));
        } else {
            formularioUsuario.getLabelMensagem().setBackground(Color.decode("#93291E"));
        }
        
        formularioUsuario.getLabelMensagem().setOpaque(true);
        formularioUsuario.getLabelMensagem().setText(mensagem);
    }
    
    private void salvarUsuario() {
        String nome = formularioUsuario.getTxtNome().getText();
        String email = formularioUsuario.getTxtEmail().getText();
        String senha = formularioUsuario.getTxtSenha().getText();
        String perfil = formularioUsuario.getComboPerfil().getSelectedItem().toString();
        
        validacaoTexto(nome);
        validacaoTexto(email);
        validacaoTexto(senha);
        validacaoPerfil();
        
        try {
            Usuario usuario = Usuario.builder()
                    .id(atualizarUsuario)
                    .nome(nome)
                    .email(email)
                    .senha(senha)
                    .perfil(perfil)
                    .foto(urlFoto)
                    .estado(formularioUsuario.getRadioAtivo().isSelected())
                    .dataCriacao(LocalDateTime.now())
                    .build();
            
            boolean resultado = usuarioServico.salvar(usuario);
            
            if (resultado) {
                mensagem(true, "Usuario salvo com sucesso!");
                limparCamposUsuario();
            } else {
                mensagem(false, "Erro ao salvar o usuario");
            }
            
        } catch (Exception e) {
            System.out.println(e);
            mensagem(false, e.getMessage());
        }
    }
    
    private void limparMensagem() {
        formularioUsuario.getLabelMensagem().setBackground(Color.WHITE);
        formularioUsuario.getLabelMensagem().setOpaque(false);
    }
    
    private void escolherArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showDialog(null, "Seleciona");
        
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            urlFoto = file.getAbsolutePath();
            formularioUsuario.getTxtFoto().setText(urlFoto);
        }
    }
    
    private void limparCamposUsuario() {
        formularioUsuario.getTxtNome().setText("");
        formularioUsuario.getTxtEmail().setText("");
        formularioUsuario.getTxtSenha().setText("");
        formularioUsuario.getTxtFoto().setText("");
        formularioUsuario.getComboPerfil().setSelectedIndex(0);
        formularioUsuario.getRadioAtivo().setSelected(true);
        urlFoto = "";
        atualizarUsuario = null;
        atualizarTabela();
    }
    
    private void preencherFormularioDeCadastro(Usuario usuario) {
        atualizarUsuario = usuario.getId();
        formularioUsuario.getTxtNome().setText(usuario.getNome());
        formularioUsuario.getTxtEmail().setText(usuario.getEmail());
        formularioUsuario.getTxtSenha().setText("");
        formularioUsuario.getTxtFoto().setText(usuario.getFoto());
        if (usuario.getPerfil().equalsIgnoreCase("admin")) {
            formularioUsuario.getComboPerfil().setSelectedIndex(1);
        } else {
            formularioUsuario.getComboPerfil().setSelectedIndex(2);
        }
        
        if (usuario.getEstado()) {
            formularioUsuario.getRadioAtivo().setSelected(true);
        } else {
            formularioUsuario.getRadioInativo().setSelected(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int linha = formularioUsuario.getTabelaUsuario().getSelectedRow();
        usuario = usuarios.get(linha);
        //atualizarUsuario = usuario.getId();
        //preencherFormularioDeCadastro(usuario);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void remover() {
        if (usuario == null) {
            String mensagem = "Deve selecionar o usuario na tabela";
            JOptionPane.showMessageDialog(null, mensagem, "Selecione a tabela", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(mensagem);
        }
        
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que quer remover?\n\n" + "Nome: " + usuario.getNome(), "Remover usuario", JOptionPane.YES_NO_OPTION);
        
        if (confirmar == JOptionPane.YES_OPTION) {
            boolean resultado = usuarioServico.remover(usuario.getId());
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Usuario removido com sucesso!");
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover o usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
}
