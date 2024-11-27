/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.entidades;

import java.math.BigDecimal;

/**
 *
 * @author Lucas
 */
public class VendaItem {
    private Long vendaId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal desconto;
    private BigDecimal preco;
    private BigDecimal total;
}
