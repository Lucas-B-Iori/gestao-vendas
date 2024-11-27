/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.controlador;

import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import com.techsoft.gestao.vendas.modelo.servico.UsuarioServico;
import com.techsoft.gestao.vendas.visao.componentes.Mensagem;
import com.techsoft.gestao.vendas.visao.formulario.Dashboard;
import com.techsoft.gestao.vendas.visao.formulario.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 *
 * @author Lucas
 */
public class LoginControlador implements ActionListener{
    private Login login;
    private UsuarioServico usuarioServico;

    public LoginControlador(Login login) {
        this.login = login;
        usuarioServico = new UsuarioServico();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        
        switch(acao) {
            case "login" -> login();
        }
    }
    
    private void login() {
        validaCampo();
        String email = login.getCampoDeTextoEmail().getText();
        String senha = String.valueOf(login.getCampoDeSenha().getPassword());
        
        String mensagem = usuarioServico.login(email, senha);
        System.out.println(mensagem);
        if (mensagem.startsWith("Email e Senha")) {
            login.getMensagemUtil().mostrarMensagem(Mensagem.TipoMensagem.SUCESSO, mensagem);
            login.getPainelCarregar().setVisible(true);
            Optional<Object> usuario = usuarioServico.buscarPeloEmail(email);
            System.out.println(usuario);
            
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    limpaCampo();
                    login.setVisible(false);
                    new Dashboard((Usuario) usuario.get()).setVisible(true);
                } catch (Exception e) {
                }
            }).start();
        } else {
            login.getMensagemUtil().mostrarMensagem(Mensagem.TipoMensagem.ERRO, mensagem);
        }
        
    }
    
    private void validaCampo() {
        String email = login.getCampoDeTextoEmail().getText();
        String senha = String.valueOf(login.getCampoDeSenha().getPassword());
        
        if (email.isBlank() || senha.isBlank()) {
            String mensagem = "Email e senha devem ser preenchidos";
            login.getMensagemUtil().mostrarMensagem(Mensagem.TipoMensagem.ERRO, mensagem);
            throw new RuntimeException(mensagem);
        }
    }
    
    private void limpaCampo() {
        login.getCampoDeTextoEmail().setText("");
        login.getCampoDeSenha().setText("");
    }
}
