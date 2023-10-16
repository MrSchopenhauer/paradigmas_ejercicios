package Carrera;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HiloCorredorP3 extends HiloCorredor {
	
    protected Semaphore finP1;
    
	public HiloCorredorP3(Corredor corredor, JPanel panel, Corredor adversario, Semaphore finP1) {
		super(corredor, panel, adversario);
		this.finP1 = finP1;
		
	}
	
	
    public void run() {
    	try {
    	finP1.acquire();
        	//acquire, lee la se;al , mientras estan esperando el dos y el cuatro, cuando el uno y el dos se liberan se ejecuta
        } catch(Exception e) {
            e.printStackTrace();
        }
        //this.numeroAleatorio = random.nextInt(2) + 6;
    	this.numeroAleatorio = 50;
        timer.start();
        
    }
}
