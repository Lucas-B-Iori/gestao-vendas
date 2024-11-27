/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.repositorio;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lucas
 */
public interface CrudRepositorio<T> {
    public boolean salvar(T t);
    public List<T> buscarTodos();
    public Optional<T> buscarPeloId(Long id);
    public boolean removerPeloId(Long id);
}
