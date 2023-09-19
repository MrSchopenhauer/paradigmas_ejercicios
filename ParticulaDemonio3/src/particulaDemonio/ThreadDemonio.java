package particulaDemonio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ThreadDemonio extends Thread{
	//VARIABLE DE SU PARTICULA A MOVER
	public Particula particula;
	//HILO A MONITOREAR
    private final Thread monitoredThread;
    //TIMER PARA LA ACCION DE MOVER
	private Timer timer;

	
    public ThreadDemonio(Thread monitoredThread, Particula particula) {
        this.monitoredThread = monitoredThread;
        this.particula = particula;

        //Accionamos el timer que pinta a la particula y rellena el contador
        timer = new Timer(10, new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	//SI EL HILO PRINCIPAL SIGUE VIVO ENTONCES EL PROCESO CONTINUA
                if (monitoredThread.isAlive()) {
                    particula.move();
                    particula.repaint();
                    //CASO CONTRARIO FINALIZA
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });   
    }

    @Override
    public void run() {

    	try {
        while (true) //{
        	//SE INICIA UNA VEZ QUE HAY UN HILO PRINCIPAL
        	if (monitoredThread.isAlive()) {
        		//LO MANDAMOS A DORMIR PARA QUE PUEDA CHAMBEAR UN RATO EL LAPIZ
			Thread.sleep(3000);
			//ARRANCA
            timer.start();}
        	else {
        		Thread.currentThread().interrupt();
        	}
       }  catch (InterruptedException e) {
			e.printStackTrace();
		}
    	finally {
    		System.out.println("Hilo Demonio Terminando"); // NUNCA SE LLAMA pq como no hay hilos usuario ya no hay hilos demonio 
	}
        }


}
