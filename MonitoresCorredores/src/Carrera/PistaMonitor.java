package Carrera;

import java.util.Random;

import javax.swing.*;

public class PistaMonitor extends JFrame {
	//corredores
    private Corredor corredor1;
    private Corredor corredor2;
    private Corredor corredor3;
    private JPanel panel;
    private Random random = new Random();
    //orden de avance
    private int contador = 1; 


    public PistaMonitor(Corredor corredor1, Corredor corredor2, Corredor corredor3, JPanel panel) {
        this.corredor1 = corredor1;
        this.corredor2 = corredor2;
        this.corredor3 = corredor3;
        this.panel = panel;
    }

    public synchronized void avanzar(Corredor corredor) {
        int x = corredor.getX();
        while (x < 720) {
            //Que turno va
            while (corredor.getId() != contador) {
                try {
                    wait(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int incremento = 60;
            x += incremento;
            corredor.move(incremento, 0, panel.getGraphics(), panel);
            panel.repaint();
            try {
            	//(Tiempo de espera al siguiente corredor)
                Thread.sleep(450);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Cambia el turno al siguiente corredor (1, 2, 3)
            contador = (contador % 3) + 1; 
            notifyAll();
        }
        JOptionPane.showMessageDialog(panel, "Llego el corredor " + corredor.getId() + " :)");
    }
}