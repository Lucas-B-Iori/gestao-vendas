/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Lucas
 */
public class Venda {
    private Long id;
    private BigDecimal totalVenda;
    private BigDecimal valorPago;
    private BigDecimal desconto;
    private BigDecimal troco;
    private Long clienteId;
    private Long usuarioId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
}
