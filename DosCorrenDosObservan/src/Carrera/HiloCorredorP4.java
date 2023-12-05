package Carrera;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HiloCorredorP4 extends HiloCorredor {
	
	protected Semaphore finP4;

	public HiloCorredorP4(Corredor corredor, JPanel panel, Corredor adversario, Semaphore finP4) {
		super(corredor, panel, adversario);
		this.finP4 = finP4;
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
                this.finP4.release(2);

            }
        });
		
	}
	
    public void run() {
        this.numeroAleatorio = random.nextInt(20) + 12;
    	//this.numeroAleatorio = 50;
        timer.start();
        
    }
}

