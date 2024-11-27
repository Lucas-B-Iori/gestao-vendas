/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.techsoft.gestao.vendas.visao.formulario;

import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import com.techsoft.gestao.vendas.visao.componentes.Menu;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author Lucas
 */
public class Dashboard extends javax.swing.JFrame {

    private FormularioPrincipal formularioPrincipal;
    private FormularioUsuario formularioUsuario;
    private int menuSelecionadoIndex = 0;
    private Menu menu;
    
    public Dashboard(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        
        if (usuario == null) {
            throw new RuntimeException("Erro ao inicializar o sistema por nao ter um usuario logado");
        }
        
        inicializarFormulario(usuario.getId());
        
        menu2.addEventoMenu(e -> {
            menuSelecionadoIndex = e;
            switch(e) {
                case 0 -> {
                    setForm(formularioPrincipal);
                }
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {
                    setForm(formularioUsuario);
                }
                case 11 -> {
                    System.exit(0);
                }
            }
        });
        setForm(formularioPrincipal);
        System.out.println("chegou aq?");
        
        
        menu2.inicializarFotoDoPerfil(usuario);
    }
    
    private void inicializarFormulario(Long usuarioId) {
        formularioPrincipal = new FormularioPrincipal();
        formularioUsuario = new FormularioUsuario(usuarioId);
    }
    
    private void setForm(JComponent component) {
        painelPrincipal.removeAll();
        painelPrincipal.add(component);
        painelPrincipal.repaint();
        painelPrincipal.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBorda1 = new com.techsoft.gestao.vendas.visao.componentes.PainelBorda();
        cabecalho1 = new com.techsoft.gestao.vendas.visao.componentes.Cabecalho();
        painelPrincipal = new javax.swing.JPanel();
        menu2 = new com.techsoft.gestao.vendas.visao.componentes.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        painelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout painelBorda1Layout = new javax.swing.GroupLayout(painelBorda1);
        painelBorda1.setLayout(painelBorda1Layout);
        painelBorda1Layout.setHorizontalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabecalho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelBorda1Layout.createSequentialGroup()
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelBorda1Layout.setVerticalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techsoft.gestao.vendas.visao.componentes.Cabecalho cabecalho1;
    private com.techsoft.gestao.vendas.visao.componentes.Menu menu2;
    private com.techsoft.gestao.vendas.visao.componentes.PainelBorda painelBorda1;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
