package particulaDemonio;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParticulaDemonio extends JPanel{

	public static void main(String[] args) {
		
		//Interfaz principal 
		JFrame contenedorPrincipal = new JFrame("Lapiz y goma");
        contenedorPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedorPrincipal.setSize(800, 200);
        
        JDesktopPane escritorioPanel = new JDesktopPane();
        contenedorPrincipal.setContentPane(escritorioPanel);
           
        //Subcontenedor del hilo de tipo usuario
        JInternalFrame usuarioContenedor = new JInternalFrame("Particula usuario", true, true, true, true);
        usuarioContenedor.setSize(800, 85);
        usuarioContenedor.setLocation(0, 0);
        
        //Subcontenedor del hilo de tipo camino
        JPanel caminoPanel = new JPanel();
        caminoPanel.setLayout(null); 
        caminoPanel.setSize(800, 200);
        caminoPanel.setLocation(0, 0);
        
        JInternalFrame caminoContenedor = new JInternalFrame(null, true, true, true, true);
        caminoContenedor.setSize(800, 100);
        caminoContenedor.setLocation(0, 40);
        
        
        //Subcontenedor del hilo de tipo demonio
        JInternalFrame demonioContenedor = new JInternalFrame("Particula demonio", true, true, true, true);
        demonioContenedor.setSize(800, 50);
        demonioContenedor.setLocation(0, 100);
        
        //Instancias de las particulas ejemplo
        Particula particula = new Particula(0,40,10,"black");
        Particula demonio = new Particula(0,0,10,"red");
        
        //Instancias de  hilos
		Thread hiloParticula = new Thread(new ThreadParticula(particula));
			//Especificando al hilo demonio
		ThreadDemonio daemonThread = new ThreadDemonio(hiloParticula, demonio);
		daemonThread.setDaemon(true);
			//Especificando el camino
        Thread threadCamino = new Thread (new ThreadCamino(caminoPanel,demonio));
		
        //Se integran los componentes a la interfaz
        usuarioContenedor.add(particula);
        escritorioPanel.add(usuarioContenedor);
        demonioContenedor.add(demonio);
        escritorioPanel.add(demonioContenedor);
        caminoContenedor.add(caminoPanel);
        escritorioPanel.add(caminoContenedor);

        //Se hace visible la interfaz
        caminoContenedor.setVisible(true);
        usuarioContenedor.setVisible(true);
        demonioContenedor.setVisible(true);
        contenedorPrincipal.setVisible(true);
        

        //Iniciamos el proceso paralelo
		hiloParticula.start();
		daemonThread.start();
		threadCamino.start();

	   
	
        
   }
}
		

