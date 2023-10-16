package Carrera;

import javax.swing.*;
import java.util.Random;

public class HiloCorredor extends JFrame implements Runnable {
	//Variables de inyeccion de dependencias 
    private Corredor corredor;
    private final Corredor adversario;
    //VARIABLES PARA GRAFICOS
    protected Timer timer;
    private JPanel panel;
    //VARIABLES PARA SET VELOCIDAD
    protected Random random = new Random();
    protected int numeroAleatorio;
 // Bandera estática compartida por los hilos
    private static boolean carreraTerminada = false; 

    public HiloCorredor(Corredor corredor, JPanel panel, Corredor adversario) {
        this.corredor = corredor;
        this.panel = panel;
        this.adversario = adversario;
        timer = new Timer(100, e -> {
            //if (!carreraTerminada && corredor.getX() < 720) {
        	if (corredor.getX() < 720) {
                // Mueve a los corredores y pasa el objeto Graphics del panel para dibujar asteriscos
                corredor.move(numeroAleatorio, 0, panel.getGraphics(), panel); 
 // Mueve al adversario
                // Redibuja el panel
                panel.repaint();
            } else {
                // Finaliza la carrera
                ((Timer) e.getSource()).stop(); 
                JOptionPane.showMessageDialog(panel, "Llego el corredor " + corredor.getId() + " :)");
                //if (!carreraTerminada) {
                    //carreraTerminada = true;
                   // JOptionPane.showMessageDialog(panel, "Llego el corredor " + corredor.getId() + " :)");
                //}
            }
        });
    }

    @Override
    public void run() {
        this.numeroAleatorio = random.nextInt(10) + 6;
        timer.start();
    }
}