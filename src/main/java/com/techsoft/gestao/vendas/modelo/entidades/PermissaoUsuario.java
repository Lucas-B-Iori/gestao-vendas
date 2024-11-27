/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.modelo.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lucas
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class PermissaoUsuario {
    Long permissaoId;
    Long usuarioId;
}
