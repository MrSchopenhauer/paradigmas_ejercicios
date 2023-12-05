package Carrera;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HiloCorredorP3 extends HiloCorredor {
	
    protected Semaphore finP1;
    protected Semaphore finP4;
    
	public HiloCorredorP3(Corredor corredor, JPanel panel, Corredor adversario, Semaphore finP1, Semaphore finP4) {
		super(corredor, panel, adversario);
		this.finP1 = finP1;
		this.finP4 = finP4;
		
	}
	
	
    public void run() {
    	try {
    	finP1.acquire();
    	finP4.acquire();
        	//acquire, lee la se;al , mientras estan esperando el dos y el cuatro, cuando el uno y el dos se liberan se ejecuta
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.numeroAleatorio = random.nextInt(20) + 12;
        timer.start();
        
    }
}
