/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.servico;

import com.techsoft.gestao.vendas.modelo.entidades.PermissaoUsuario;
import com.techsoft.gestao.vendas.modelo.repositorio.impl.PermissaoRepositorioImpl;
import com.techsoft.gestao.vendas.modelo.repositorio.impl.PermissaoUsuarioRepositorioImpl;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class PermissaoServico {
    private PermissaoRepositorioImpl permissaoRepositorioImpl;
    private PermissaoUsuarioRepositorioImpl permissaoUsuarioRepositorioImpl;

    public PermissaoServico() {
        permissaoRepositorioImpl = new PermissaoRepositorioImpl();
        permissaoUsuarioRepositorioImpl = new PermissaoUsuarioRepositorioImpl();
    }
    
    public void validarPermissao(Long permissaoId, Long usuarioId) {
        List<PermissaoUsuario> lista = permissaoUsuarioRepositorioImpl.buscarPeloPermissaoIdEUsuarioId(permissaoId, usuarioId);
        if(lista.isEmpty()) {
            String mensagem = "Sem permissao";
            JOptionPane.showMessageDialog(null, mensagem, mensagem, JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(mensagem);
        }
    }
    
    
}
