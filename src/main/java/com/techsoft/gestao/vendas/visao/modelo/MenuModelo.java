/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.visao.modelo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lucas
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuModelo {
    private String icon;
    private String nome;
    private TipoMenu tipoMenu;
    
    public enum TipoMenu {
        MENU, TITULO, VAZIO;
    }
    
    public Icon toIcon() {
        return new ImageIcon(System.getProperty("user.dir")  + "/src/main/java/com/techsoft/gestao/vendas/visao/icon/" + icon + ".png");

    }
 }
