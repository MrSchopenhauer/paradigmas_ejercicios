package particulaDemonio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ThreadDemonio extends Thread{
	
	public Particula particula;
    private final Thread monitoredThread;
	private Timer timer;
    public final JProgressBar progreso;
	
    public ThreadDemonio(Thread monitoredThread, Particula particula, JProgressBar progreso) {
        this.monitoredThread = monitoredThread;
        this.particula = particula;
        this.progreso= progreso;
        
        //Accionamos el timer que pinta a la particula y rellena el contador
        timer = new Timer(10, new ActionListener() {
        	int progressValue = 430;
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monitoredThread.isAlive()) {
                    particula.move();
                    particula.repaint();
	                progressValue = progressValue-1; 
	                progreso.setValue(progressValue);
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        
    }

    @Override
    public void run() {

    	try {
        while (true) {
        	if (monitoredThread.isAlive()) {
			Thread.sleep(5000);
            timer.start();}
        	else {
        		Thread.currentThread().interrupt();
        	}
        } } catch (InterruptedException e) {
			e.printStackTrace();
		}
    	finally {
    		System.out.println("Hilo Demonio Terminando"); // never called pq como no hay hilos usuario ya no hay hilos demonio 
		}
        }


}
