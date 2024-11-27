/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.repositorio.impl;

import com.techsoft.gestao.vendas.modelo.conexao.ConexaoMySQL;
import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lucas
 */
public class UsuarioRepositorioImpl extends CrudRepositorioImpl {

    public UsuarioRepositorioImpl() {
        super(Usuario.class);
    }
    
    public Optional<Object> buscarPeloEmail(String email) {
        try {
            String SQL = "SELECT * FROM usuario WHERE email = ?";
            
            PreparedStatement ps = ConexaoMySQL.obterConexao().prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                return Optional.ofNullable(getT(resultSet));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return Optional.empty();
    }
    
    public static void main(String[] args) {
        Usuario usuario = Usuario.builder()
                .nome("Lucas Iori")
                .email("lucasiori@gmail.com")
                .senha(new BCryptPasswordEncoder().encode("1234"))
                .perfil("diferente")
                .dataCriacao(LocalDateTime.now())
                .estado(true)
                .build();
        
        UsuarioRepositorioImpl rep = new UsuarioRepositorioImpl();
        rep.salvar(usuario);
    }
}
