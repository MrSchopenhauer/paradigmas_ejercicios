package Carrera;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HiloProductorCorredor extends Thread{
	
	private CorredorEnMovimiento productorEnMovimiento;
	private int nuevaX;

	public HiloProductorCorredor(CorredorEnMovimiento productorEnMovimiento,JPanel panel) {
		this.productorEnMovimiento = productorEnMovimiento;

	}
	
	public void run() {
		
			
	}

	
	/*
	//Variables de inyeccion de dependencias 
    private Corredor corredor;
    private final Corredor adversario;
    //VARIABLES PARA GRAFICOS
    private Timer timer;
    private JPanel panel;
    //VARIABLES PARA SET VELOCIDAD
    private Random random = new Random();
    private int numeroAleatorio;
 // Bandera estática compartida por los hilos
    private static boolean carreraTerminada = false; 
    
    public HiloCorredor(Corredor corredor, JPanel panel, Corredor adversario) {
        this.corredor = corredor;
        this.panel = panel;
        this.adversario = adversario;
        timer = new Timer(100, e -> {
            if (!carreraTerminada && corredor.getX() < 720) {
                // Mueve a los corredores y pasa el objeto Graphics del panel para dibujar asteriscos
                /*corredor.move(numeroAleatorio, 0, panel.getGraphics(), panel); */
 // Mueve al adversario
                // Redibuja el panel
                /*panel.repaint();
            } else {
                // Finaliza la carrera
                ((Timer) e.getSource()).stop(); 
                if (!carreraTerminada) {
                    carreraTerminada = true;
                    JOptionPane.showMessageDialog(panel, "Gana el corredor " + corredor.getId() + " :)");
                }
            }
        });
    }

    @Override
    public void run() {
        this.numeroAleatorio = random.nextInt(2) + 6;
        timer.start();
    }
}
*/
}
