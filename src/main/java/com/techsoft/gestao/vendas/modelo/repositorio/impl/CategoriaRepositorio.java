/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.repositorio.impl;

import com.techsoft.gestao.vendas.modelo.entidades.Categoria;

/**
 *
 * @author Lucas
 */
public class CategoriaRepositorio extends CrudRepositorioImpl {

    public CategoriaRepositorio() {
        super(Categoria.class);
    }
    
    public static void main(String[] args) {
        Categoria categoria = Categoria.builder()
                .id(1L)
                .nome("Livro")
                .descricao("Conhecimento é poder")
                .build();
        
        CategoriaRepositorio repositorio = new CategoriaRepositorio();
        
        System.out.println("RESULTADO: " + repositorio.removerPeloId(2L));
    }
    
}
