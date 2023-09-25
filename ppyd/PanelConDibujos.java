/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppyd;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Diego Irving
 */
public class PanelConDibujos {

    public static void main(String args[]) {

        MarcoConDibujos mimarco = new MarcoConDibujos();

        mimarco.setVisible(true);

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConDibujos extends JFrame {

    public MarcoConDibujos() {
        setTitle("Prueba de dibujo");

        setSize(400, 400);

        LaminaConFiguras lamina = new LaminaConFiguras();

        add(lamina);
    }

}

class LaminaConFiguras extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawRect(50, 50, 200, 200);
        //cara delantera cubo1
        g.drawLine(50, 100, 300, 100);
        g.drawLine(300, 100, 300, 350);
        g.drawLine(300, 350, 50, 350);
        g.drawLine(50, 350, 50, 100);
        //cara trasera cubo1
        g.drawLine(200, 50, 450, 50);
        g.drawLine(450, 50, 450, 300);
        g.drawLine(450, 300, 200, 300);
        g.drawLine(200, 300, 200, 50);
        //caras laterales cubo1
        g.drawLine(50, 100, 200, 50);
        g.drawLine(300, 100, 450, 50);
        g.drawLine(300, 350, 450, 300);
        g.drawLine(50, 350, 200, 300);
        //cara delantera cubo2
        g.drawLine(700, 100, 950, 100);
        g.drawLine(950, 100, 950, 350);
        g.drawLine(950, 350, 700, 350);
        g.drawLine(700, 350, 700, 100);
        //cara trasera cubo2
        g.drawLine(850, 50, 1100, 50);
        g.drawLine(1100, 50, 1100, 300);
        g.drawLine(1100, 300, 850, 300);
        g.drawLine(850, 300, 850, 50);
        //caras laterales cubo2
        g.drawLine(700, 100, 850, 50);
        g.drawLine(950, 100, 1100, 50);
        g.drawLine(950, 350, 1100, 300);
        g.drawLine(700, 350, 850, 300);
        
    }
}
