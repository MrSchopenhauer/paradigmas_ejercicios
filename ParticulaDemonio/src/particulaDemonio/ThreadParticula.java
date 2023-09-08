package particulaDemonio;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ThreadParticula implements Runnable{
    public Particula particula;
    public final JProgressBar progreso;
    private Timer timer;
    public volatile boolean running = true; // Una bandera que nos permite accionar y terminar el hilo

    public ThreadParticula(Particula particula2, JProgressBar progreso) {
        this.particula = particula2;
        this.progreso= progreso;
        // Timer para accionar el proceso
        timer = new Timer(10, new ActionListener() {
        	int progressValue = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (particula.x < 780) {
                    particula.move();
                    particula.repaint();
	                progressValue = particula.x; 
	                progreso.setValue(progressValue);
                } else {
                    ((Timer) e.getSource()).stop();
                    running = false; 
                }
            }
        });
    }

    public void run() {
        try {
            while (running) { 
                timer.start();
            }
        } finally {
            System.out.println("Finalizado");
        }
    }

    public void stopThread() {
        running = false;
        Thread.currentThread().interrupt();
    }
}