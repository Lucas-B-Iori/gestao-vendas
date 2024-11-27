/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.entidades;

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
public class EstoqueHistorico {
    private Long id;
    private String produto;
    private Integer quantidade;
    private String estado;
    private String observacao;
    private String usuarioId;
    private LocalDateTime dataCriacao;
}
