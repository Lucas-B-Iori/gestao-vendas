/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lucas
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private BigDecimal preco;
    private Long usuarioId;
    private Long categoriaId;
    private LocalDateTime dataCriacao;
}
