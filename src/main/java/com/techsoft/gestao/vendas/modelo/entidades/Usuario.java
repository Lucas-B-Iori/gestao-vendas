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
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private String foto;
    private Boolean estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimoLogin;
}
