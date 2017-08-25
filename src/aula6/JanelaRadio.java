/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
class JanelaRadio extends JFrame {
    private final JTextField mensagem = new JTextField("Universidade Federal de Juiz de Fora");
    private final JRadioButton rbPlano;
    private final JRadioButton rbnegrito;
    private final JRadioButton rbitalico;
    private final JRadioButton rbosdois;
    public JanelaRadio() throws HeadlessException {
        super("Aula5");
        
        setLayout(new FlowLayout());
        rbPlano = new JRadioButton("Plano",true);
        rbnegrito = new JRadioButton("Negrito",false);
        rbitalico = new JRadioButton("Italico",false);
        rbosdois = new JRadioButton("Negrito e Italico",false);
        add(mensagem);
        add(rbPlano);
        add(rbnegrito);
        add(rbitalico);
        add(rbosdois);
        
        ButtonGroup bgEstilo = new ButtonGroup();
        bgEstilo.add(rbPlano);
        bgEstilo.add(rbnegrito);
        bgEstilo.add(rbitalico);
        bgEstilo.add(rbosdois);
        Font fPlano = new Font(Font.SERIF, Font.PLAIN, 14);
        Font fNegrito = new Font(Font.SERIF, Font.BOLD, 14);
        Font fItalico = new Font(Font.SERIF, Font.ITALIC, 14);
        Font fOsdois = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 14);
        rbPlano.addItemListener(new EstiloRadio(fPlano));
        rbnegrito.addItemListener(new EstiloRadio(fNegrito));
        rbitalico.addItemListener(new EstiloRadio(fItalico));
        rbosdois.addItemListener(new EstiloRadio(fOsdois));
    }

    private class EstiloRadio implements ItemListener {
        private Font fonte;
        public EstiloRadio(Font fPlano) {
            this.fonte = fPlano;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
           mensagem.setFont(fonte);
        }
    }
    
    
}
