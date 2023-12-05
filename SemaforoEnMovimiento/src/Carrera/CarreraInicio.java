package Carrera;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class CarreraInicio {
	//Semaforos 
    protected static Semaphore finP1;
    //Para otro corredor paralelo
    protected static Semaphore finP4;
    
    public static void main(String[] args) {
    	//Set del frame
        JFrame frame = new JFrame("Carrera de caballeros");
        frame.setSize(800, 400); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Lista de corredores
        List<Corredor> corredores = new ArrayList<>();

        // Instancia a los corredores y adicion a la lista de corredores
        Corredor corredor1 = new Corredor(0, 50, 1); 
        Corredor corredor2 = new Corredor(0, 150, 2); 
        //TERCERO EN DISCORDIA 
        Corredor corredor3 = new Corredor(0, 250, 3);
        
        // CUARTO POR SI ACASO
        //Corredor corredor4 = new Corredor(0,300,4);
        
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        //Cuarto por si acaso 
        //corredores.add(corredor4);

        // Instancia de panel, indicacion de color
        JPanel panel = new JPanel() {
            @Override
            //Panel que dibuja a los corredores
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //Por cada corredor dentro del arreglo de corredores, dibujar a cada corredor
                for (Corredor corredor : corredores) {
                    corredor.draw(g);
                }
            }
        };
        panel.setBackground(Color.GREEN);
        frame.add(panel); // Agregar el JPanel al JFrame
        
        // Instancia de hilos
        	//Semaforos
        finP1 = new Semaphore(0,true);
        //por si acaso
        finP4 = new Semaphore(0,true);
        	//Usuarios/corredores
        Thread hiloCorredor1 = new Thread(new HiloCorredorP1(corredor1, panel, corredor2,finP1));
        Thread hiloCorredor2 = new Thread(new HiloCorredorP2(corredor2, panel, corredor1,finP1));
        Thread hiloCorredor3 = new Thread(new HiloCorredorP3(corredor3, panel, corredor1,finP1));
        	//Demonio, limpian los asteriscos
        //Thread hiloDemonio = new Thread(new HiloDemonio(corredores, panel));
        //hiloDemonio.setDaemon(true); 

        
        //Inicio del programa
        	//Hacer visible el frame
        frame.setVisible(true); 
        	//Iniciar a los hilos
        //hiloDemonio.start();
        hiloCorredor1.start();
        hiloCorredor2.start();
        hiloCorredor3.start();
    }
}