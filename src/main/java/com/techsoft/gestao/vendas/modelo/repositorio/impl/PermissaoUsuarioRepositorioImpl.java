/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.repositorio.impl;

import com.techsoft.gestao.vendas.modelo.conexao.ConexaoMySQL;
import com.techsoft.gestao.vendas.modelo.entidades.PermissaoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class PermissaoUsuarioRepositorioImpl extends CrudRepositorioImpl<PermissaoUsuario> {

    public PermissaoUsuarioRepositorioImpl() {
        super(PermissaoUsuario.class);
    }
    
    public List<PermissaoUsuario> buscarPeloUsuarioId(Long usuarioId) {
        List<PermissaoUsuario> lista = new ArrayList<>();
        try {
            String sql = "select pu.* from usuario u, permissao p, permissaousuario pu\n" + 
                        "WHERE pu.permissaoId = p.id AND pu.usuarioId = ?";
            
            PreparedStatement ps = ConexaoMySQL.obterConexao().prepareStatement(sql);
            
            ps.setLong(1, usuarioId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                lista.add(getT(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    
    public List<PermissaoUsuario> buscarPeloPermissaoIdEUsuarioId(Long permissaoId, Long usuarioId) {
        List<PermissaoUsuario> lista = new ArrayList<>();
        System.out.println(permissaoId + " " + usuarioId);
        try {
            String sql = "select pu.* from usuario u, permissao p, permissaousuario pu\n" + 
                        "WHERE pu.permissaoId = ? AND pu.usuarioId = ?";
            
            PreparedStatement ps = ConexaoMySQL.obterConexao().prepareStatement(sql);
            
            ps.setLong(1, permissaoId);
            ps.setLong(2, usuarioId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                System.out.println("Result: "+ rs.getLong(1));
                lista.add(getT(rs));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
}
