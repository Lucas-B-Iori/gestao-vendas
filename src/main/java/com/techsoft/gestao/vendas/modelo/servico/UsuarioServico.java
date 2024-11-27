/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.servico;

import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import com.techsoft.gestao.vendas.modelo.repositorio.impl.UsuarioRepositorioImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lucas
 */
public class UsuarioServico {
    private UsuarioRepositorioImpl usuarioRepositorio;

    public UsuarioServico() {
        usuarioRepositorio = new UsuarioRepositorioImpl();
    }
    
    public String login(String email, String senha) {
        Optional usuarioOptional = buscarPeloEmail(email);
        
        if (usuarioOptional.isPresent()) {
            Usuario usuario = (Usuario) usuarioOptional.get();
        
            if (validaSenha(senha, usuario.getSenha())) {
                if (!usuario.getEstado()) {
                    return "Usuario bloqueado. Valida com o admin";
                }
                
                return "Email e Senha corretos";
            }
            
            return "Email ou senha incorreta";
        }
        
        return "Usuario Inexistente";
    }
    
    public boolean validaSenha(String senhaInserida, String senhaUsuario) {
        return new BCryptPasswordEncoder().matches(senhaInserida, senhaUsuario);
    }
    
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.buscarTodos();
    }
    
    public Optional<Usuario> buscarPeloId(Long id) {
        return usuarioRepositorio.buscarPeloId(id);
    }
    
    public Optional<Object> buscarPeloEmail(String email) {
        return usuarioRepositorio.buscarPeloEmail(email);
    }
    
    public boolean salvar(Usuario usuario) {
        
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        
        return usuarioRepositorio.salvar(usuario);
    }
    
    public boolean remover(Long id) {
        return usuarioRepositorio.removerPeloId(id);
    }
    
}
