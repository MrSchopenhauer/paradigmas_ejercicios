package Carrera;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

//Similar con UsaAscensor
public class CarreraInicio {
    public static void main(String[] args) {
    	//COrredores
        Corredor corredor1 = new Corredor(0, 50, 1);
        Corredor corredor2 = new Corredor(0, 150, 2);
        Corredor corredor3 = new Corredor(0, 250, 3);
        //Pista y componentes visuales
        JFrame frame = new JFrame("Carrera de caballos gueros");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                corredor1.draw(g);
                corredor2.draw(g);
                corredor3.draw(g);
            }
        };
        panel.setBackground(Color.GREEN);
        frame.add(panel);

        //Monitor
        PistaMonitor pistaMonitor = new PistaMonitor(corredor1, corredor2, corredor3, panel);
        //Hilos
        Thread hiloCorredor1 = new Thread(new HiloCorredor(corredor1, pistaMonitor));
        Thread hiloCorredor2 = new Thread(new HiloCorredor(corredor2, pistaMonitor));
        Thread hiloCorredor3 = new Thread(new HiloCorredor(corredor3, pistaMonitor));
        //Inicializacion 
        frame.setVisible(true);
        hiloCorredor1.start();
        hiloCorredor2.start();
        hiloCorredor3.start();
    }
}





