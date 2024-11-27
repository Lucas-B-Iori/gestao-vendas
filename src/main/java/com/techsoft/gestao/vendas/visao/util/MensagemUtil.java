/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsoft.gestao.vendas.visao.util;

import com.techsoft.gestao.vendas.visao.componentes.Mensagem;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Lucas
 */
public class MensagemUtil {
    private final JLayeredPane background;
    private final MigLayout layout;

    public MensagemUtil(JLayeredPane background, MigLayout layout) {
        this.background = background;
        this.layout = layout;
    }
    
    public void mostrarMensagem(Mensagem.TipoMensagem tipo, String mensagem) {
        Mensagem ms = new Mensagem();
        
        ms.mostrarMensagem(tipo, mensagem);
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isMostra()) {
                    background.add(ms, "pos 0.al 20", 0);
                    ms.setVisible(true);
                    background.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                
                if(ms.isMostra()) {
                    f = 20 * (1f - fraction);
                } else {
                    f = 20 * fraction;
                }
                
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 20) );
                background.repaint();
                background.revalidate();
            }

            @Override
            public void end() {
                if (ms.isMostra()) {
                    background.remove(ms);
                    background.repaint();
                    background.revalidate();
                } else {
                    ms.setMostra(true);
                }
            }
                                  
        };
        
        Animator animator = new Animator(300, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        animator.start();
        
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }).start();
    }
}
