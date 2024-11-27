/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.techsoft.gestao.vendas.visao.formulario;

import com.techsoft.gestao.vendas.visao.modelo.CartaoModelo;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class FormularioPrincipal extends javax.swing.JPanel {

    public FormularioPrincipal() {
        initComponents();
        inicializarCartao();
    }

    private void inicializarCartao() {
        CartaoModelo cartaoModelo = new CartaoModelo(new ImageIcon(getCaminho() + "produto.png"), "Produto", "Total 10");
        CartaoModelo cartaoModelo1 = new CartaoModelo(new ImageIcon(getCaminho() + "venda.png"), "Venda", "Total 10");
        CartaoModelo cartaoModelo2 = new CartaoModelo(new ImageIcon(getCaminho() + "stock.png"), "Estoque", "Total 10");
        
        cartao4.setData(cartaoModelo);
        cartao5.setData(cartaoModelo1);
        cartao6.setData(cartaoModelo2);
    }
    
    private String getCaminho() {
        return System.getProperty("user.dir")  + "/src/main/java/com/techsoft/gestao/vendas/visao/icon/";
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cartao4 = new com.techsoft.gestao.vendas.visao.componentes.Cartao();
        cartao5 = new com.techsoft.gestao.vendas.visao.componentes.Cartao();
        cartao6 = new com.techsoft.gestao.vendas.visao.componentes.Cartao();
        painelBorda1 = new com.techsoft.gestao.vendas.visao.componentes.PainelBorda();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new com.techsoft.gestao.vendas.visao.componentes.Tabela();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        cartao4.setCor1(new java.awt.Color(0, 180, 219));
        cartao4.setCor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao4);

        cartao5.setCor1(new java.awt.Color(48, 43, 99));
        cartao5.setCor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao5);

        cartao6.setCor1(new java.awt.Color(176, 106, 179));
        cartao6.setCor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao6);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(130, 130, 130));
        jLabel1.setText("Histórico do Estoque");

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Estado", "Motivo", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela1);

        javax.swing.GroupLayout painelBorda1Layout = new javax.swing.GroupLayout(painelBorda1);
        painelBorda1.setLayout(painelBorda1Layout);
        painelBorda1Layout.setHorizontalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelBorda1Layout.setVerticalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techsoft.gestao.vendas.visao.componentes.Cartao cartao4;
    private com.techsoft.gestao.vendas.visao.componentes.Cartao cartao5;
    private com.techsoft.gestao.vendas.visao.componentes.Cartao cartao6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.techsoft.gestao.vendas.visao.componentes.PainelBorda painelBorda1;
    private com.techsoft.gestao.vendas.visao.componentes.Tabela tabela1;
    // End of variables declaration//GEN-END:variables
}
