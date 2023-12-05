package Carrera;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.concurrent.Semaphore;

public class HiloCorredorP2 extends HiloCorredor {
    protected Semaphore finP1;

    
	public HiloCorredorP2(Corredor corredor, JPanel panel, Corredor adversario, Semaphore finP1) {
		super(corredor, panel, adversario);
		this.finP1 = finP1;
		
		timer = new Timer(100, e -> {
            //if (!carreraTerminada && corredor.getX() < 720) {
        	if (corredor.getX() < 720) {
                // Mueve a los corredores y pasa el objeto Graphics del panel para dibujar asteriscos
                corredor.move(numeroAleatorio, 0, panel.getGraphics(), panel); 
                // Redibuja el panel
                panel.repaint();
            } else {
                // Finaliza la carrera
                ((Timer) e.getSource()).stop(); 
                JOptionPane.showMessageDialog(panel, "Llego el corredor " + corredor.getId() + " :)");
                this.finP1.release(1);

            }
        });
		
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
