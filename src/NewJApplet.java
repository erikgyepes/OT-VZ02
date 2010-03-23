/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Dano
 */
public class NewJApplet extends JApplet implements ActionListener {

    JTextField tf;
    JButton jbtn;

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        setLayout(null);

        tf = new JTextField("5");
        jbtn = new JButton("Vykresli");

        tf.setBounds(10, 10, 20, 20);
        jbtn.setBounds(40, 10, 100, 20);

        jbtn.addActionListener(this);

        add(tf);
        add(jbtn);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtn) {
            tf.setVisible(false);
            jbtn.setVisible(false);

            Graphics g = getGraphics();

            g.drawLine(100, 50, 100, 150);
            g.drawLine(130, 50, 130, 150);

            int pocet = Integer.parseInt(tf.getText());
            int krok = (int) (90 / (pocet - 1));

            if (krok == 0) {
                g.fillRect(100, 55, 30, 90);
            } else {
                for (int i = 0; i < pocet; i++) {
                    //System.out.println(20+i*10);
                    g.drawLine(100, 55 + i * krok, 130, 55 + i * krok);
                }
            }
        }
    }
    // TODO overwrite start(), stop() and destroy() methods
}
