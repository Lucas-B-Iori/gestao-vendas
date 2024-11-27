/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.techsoft.gestao.vendas.visao.componentes;

import com.techsoft.gestao.vendas.modelo.entidades.Usuario;
import com.techsoft.gestao.vendas.visao.evento.EventoMenuSelecionado;
import com.techsoft.gestao.vendas.visao.modelo.MenuModelo;
import static com.techsoft.gestao.vendas.visao.modelo.MenuModelo.TipoMenu.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class Menu extends javax.swing.JPanel {
    
    private EventoMenuSelecionado evento;

    public Menu() {
        initComponents();
        setOpaque(false);
        listaMenu1.setOpaque(false);
        inicializarMenu();
    }
    
    public void addEventoMenu(EventoMenuSelecionado evento) {
        this.listaMenu1.AddEventoMenu(evento);
    }
    
    private void inicializarMenu() {
        listaMenu1.adicionarItem(new MenuModelo("1", "Dashboard", MENU));
        listaMenu1.adicionarItem(new MenuModelo("2", "Produto", MENU));
        listaMenu1.adicionarItem(new MenuModelo("3", "Estoque", MENU));
        listaMenu1.adicionarItem(new MenuModelo("4", "Cliente", MENU));
        listaMenu1.adicionarItem(new MenuModelo("5", "Venda", MENU));
        listaMenu1.adicionarItem(new MenuModelo("6", "Usuario", MENU));
        
        listaMenu1.adicionarItem(new MenuModelo("", "", VAZIO));
        listaMenu1.adicionarItem(new MenuModelo("", "Suporte", TITULO));
        listaMenu1.adicionarItem(new MenuModelo("7", "Configuração", MENU));
        listaMenu1.adicionarItem(new MenuModelo("8", "Relatório", MENU));
        listaMenu1.adicionarItem(new MenuModelo("9", "Fale conosco", MENU));
        listaMenu1.adicionarItem(new MenuModelo("10", "Sair", MENU));
    }
    
    public void inicializarFotoDoPerfil(Usuario usuario) {
        labelNomeUsuario.setText(usuario.getNome());
        
        if (usuario.getFoto() != null) {
            try {
                File file = new File(usuario.getFoto());
                if (file.isFile()) {
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    imagemAvatar1.setImage(icon);
                }
            } catch (Exception e) {
                System.out.println("Erro ao carregar foto do usuario");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        graphics2D.setPaint(gradientPaint);
        
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        graphics2D.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        imagemAvatar1 = new com.techsoft.gestao.vendas.visao.componentes.ImagemAvatar();
        labelNomeUsuario = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        listaMenu1 = new com.techsoft.gestao.vendas.visao.componentes.ListaMenu<>();

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lucas\\OneDrive\\Área de Trabalho\\icon\\logo 39x45.png")); // NOI18N
        jLabel1.setText("SOFT");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imagemAvatar1.setBorderSize(1);
        imagemAvatar1.setImage(new javax.swing.ImageIcon("C:\\Users\\Lucas\\OneDrive\\Documentos\\NetBeansProjects\\gestaoVendas02\\src\\main\\java\\com\\techsoft\\gestao\\vendas\\visao\\icon\\avatar.png")); // NOI18N

        labelNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeUsuario.setText("Lucas Bertolassi Iori");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(labelNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(imagemAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techsoft.gestao.vendas.visao.componentes.ImagemAvatar imagemAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelNomeUsuario;
    private com.techsoft.gestao.vendas.visao.componentes.ListaMenu<String> listaMenu1;
    // End of variables declaration//GEN-END:variables
}
