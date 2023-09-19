package particulaDemonio;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParticulaDemonio extends JPanel{

	public static void main(String[] args) {
		
		//Interfaz principal 
		JFrame contenedorPrincipal = new JFrame("Particulas");
        contenedorPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedorPrincipal.setSize(800, 500);
        
        JPanel panelParticula = new JPanel();
        panelParticula.setBounds(0, 0, 800, 200);
        JPanel panelParticula2 = new JPanel();
        panelParticula2.setBounds(0, 200, 800, 200);
        JPanel panelParticula3 = new JPanel();
        panelParticula3.setBounds(0, 400, 800, 200);
        
        contenedorPrincipal.add(panelParticula);
        contenedorPrincipal.add(panelParticula2);
        contenedorPrincipal.add(panelParticula3);
        
        //JDesktopPane escritorioPanel = new JDesktopPane();
        //contenedorPrincipal.setContentPane(escritorioPanel);
        
        //Indicador del recorrido o trabajo del usuario y de la limpieza del demonio
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMaximum(780);
        
       // panelParticula3.add(progressBar);
        progressBar.setSize(200, 20);
        //progressBar.setLocation(0, 400);
        
        //Subcontenedor del hilo de tipo usuario
        //JInternalFrame usuarioContenedor = new JInternalFrame("Particula usuario", true, true, true, true);
        //usuarioContenedor.setSize(800, 200);
        //usuarioContenedor.setLocation(0, 0);
        
        //Subcontenedor del hilo de tipo demonio
        //JInternalFrame demonioContenedor = new JInternalFrame("Particula demonio", true, true, true, true);
        //demonioContenedor.setSize(800, 200);
        //demonioContenedor.setLocation(0, 200);
        
        //Instancias de las particulas ejemplo
        Particula particula = new Particula(0,100,10,"black");
        Particula demonio = new Particula(0,100,10,"red");
        
        //Instancias de ambos hilos
		Thread hiloParticula = new Thread(new ThreadParticula(particula,progressBar));
		//Especificando al hilo demonio
		ThreadDemonio daemonThread = new ThreadDemonio(hiloParticula, demonio, progressBar);
		daemonThread.setDaemon(true);
		
        //Se integran los componentes a la interfaz
        panelParticula.add(particula);
        panelParticula2.add(demonio);

        //Se hace visible la interfaz
       // usuarioContenedor.setVisible(true);
        //demonioContenedor.setVisible(true);
        contenedorPrincipal.setVisible(true);
        
        //Iniciamos el proceso paralelo
		hiloParticula.start();
		daemonThread.start();

	   
	
        
   }
}
		

