
package com.techsoft.gestao.vendas.visao.formulario;

import com.techsoft.gestao.vendas.controlador.LoginControlador;
import com.techsoft.gestao.vendas.visao.componentes.Botao;
import com.techsoft.gestao.vendas.visao.componentes.CampoDeSenha;
import com.techsoft.gestao.vendas.visao.componentes.CampoDeTexto;
import com.techsoft.gestao.vendas.visao.componentes.PainelCarregar;
import com.techsoft.gestao.vendas.visao.util.MensagemUtil;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class Login extends javax.swing.JFrame {

    private MigLayout layout;
    private PainelCarregar painelCarregar;
    private MensagemUtil mensagemUtil;
    private LoginControlador loginControlador;
    
    private int x;
    private int y;
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        loginControlador = new LoginControlador(this);
        
        layout = new MigLayout("fill, insets");
        painelCarregar = new PainelCarregar();
        
        background.setLayout(layout);
        background.add(painelCarregar, "pos 0 0 100% 100%");
        background.add(painelBorda1, "pos 0 0 100% 100%");
        
        mensagemUtil = new MensagemUtil(background, layout);
        evento();
        moveTelaLogin(this);
        fecharTela();
    }
    
    private void moveTelaLogin(JFrame frame) {
        painelMovimento.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = getX();
                y = getY();
            }
           
        });
        
        painelMovimento.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
            
        });
    }
    
    private void fecharTela() {
        labelFechar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Sair", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        labelFechar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelFechar.setBackground(Color.RED);
                labelFechar.setForeground(Color.WHITE);
                labelFechar.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelFechar.setOpaque(false);
                labelFechar.setForeground(Color.WHITE);
            }
            
            
            
        });
    }
        
    private void evento() {
        botaoLogin.addActionListener(loginControlador);
    }

    public MensagemUtil getMensagemUtil() {
        return mensagemUtil;
    }

    public PainelCarregar getPainelCarregar() {
        return painelCarregar;
    }

    public CampoDeSenha getCampoDeSenha() {
        return campoDeSenha;
    }

    public CampoDeTexto getCampoDeTextoEmail() {
        return campoDeTextoEmail;
    }

    public Botao getBotaoLogin() {
        return botaoLogin;
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBorda1 = new com.techsoft.gestao.vendas.visao.componentes.PainelBorda();
        painelMovimento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelFechar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoDeTextoEmail = new com.techsoft.gestao.vendas.visao.componentes.CampoDeTexto();
        campoDeSenha = new com.techsoft.gestao.vendas.visao.componentes.CampoDeSenha();
        botaoLogin = new com.techsoft.gestao.vendas.visao.componentes.Botao();
        background = new javax.swing.JLayeredPane();

        painelBorda1.setCor1(new java.awt.Color(255, 255, 255));
        painelBorda1.setCor2(new java.awt.Color(67, 137, 162));

        painelMovimento.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lucas\\Downloads\\icon\\icon\\logo 39x45.png")); // NOI18N
        jLabel1.setText("SOFT");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        labelFechar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelFechar.setForeground(new java.awt.Color(255, 255, 255));
        labelFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFechar.setText("X");

        javax.swing.GroupLayout painelMovimentoLayout = new javax.swing.GroupLayout(painelMovimento);
        painelMovimento.setLayout(painelMovimentoLayout);
        painelMovimentoLayout.setHorizontalGroup(
            painelMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMovimentoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(labelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(painelMovimentoLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        painelMovimentoLayout.setVerticalGroup(
            painelMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addGroup(painelMovimentoLayout.createSequentialGroup()
                        .addComponent(labelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        campoDeTextoEmail.setCor(new java.awt.Color(255, 255, 255));
        campoDeTextoEmail.setDicas("Email");
        campoDeTextoEmail.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\Lucas\\Downloads\\icon\\icon\\mail.png")); // NOI18N

        campoDeSenha.setCor(new java.awt.Color(255, 255, 255));
        campoDeSenha.setDicas("Senha");
        campoDeSenha.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\Lucas\\Downloads\\icon\\icon\\pass.png")); // NOI18N
        campoDeSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDeSenhaActionPerformed(evt);
            }
        });

        botaoLogin.setBackground(new java.awt.Color(28, 168, 224));
        botaoLogin.setForeground(new java.awt.Color(255, 255, 255));
        botaoLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lucas\\Downloads\\icon\\icon\\login_16.png")); // NOI18N
        botaoLogin.setText("LOGIN");
        botaoLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout painelBorda1Layout = new javax.swing.GroupLayout(painelBorda1);
        painelBorda1.setLayout(painelBorda1Layout);
        painelBorda1Layout.setHorizontalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoDeTextoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoDeSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBorda1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        painelBorda1Layout.setVerticalGroup(
            painelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBorda1Layout.createSequentialGroup()
                .addComponent(painelMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoDeTextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDeSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDeSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDeSenhaActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    private com.techsoft.gestao.vendas.visao.componentes.Botao botaoLogin;
    private com.techsoft.gestao.vendas.visao.componentes.CampoDeSenha campoDeSenha;
    private com.techsoft.gestao.vendas.visao.componentes.CampoDeTexto campoDeTextoEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFechar;
    private com.techsoft.gestao.vendas.visao.componentes.PainelBorda painelBorda1;
    private javax.swing.JPanel painelMovimento;
    // End of variables declaration//GEN-END:variables
}
