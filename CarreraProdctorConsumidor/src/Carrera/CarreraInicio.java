package Carrera;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraInicio {

    public static void main(String[] args) {
    	//Set del frame
        JFrame frame = new JFrame("Carrera de caballeros");
        frame.setSize(800, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Lista de corredores
        List<Corredor> corredores = new ArrayList<>();

        // Instancia a los corredores y adicion a la lista de corredores
        Corredor corredorProductor = new Corredor(0, 50, 1); 
        Corredor corredor2 = new Corredor(0, 150, 2); 
        corredores.add(corredorProductor);
        corredores.add(corredor2);

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
        	//Usuarios/corredores
        CorredorEnMovimiento corredorEnMovimientoProductor = new CorredorEnMovimiento(corredorProductor, corredor2, panel);
        Thread hiloCorredor1 = new Thread(new HiloProductorCorredor(corredorEnMovimientoProductor, panel));
        //Thread hiloCorredor2 = new Thread(new HiloCorredor(corredor2, panel, corredor1));
        	//Demonio, limpian los asteriscos
        Thread hiloDemonio = new Thread(new HiloDemonio(corredores, panel));
        hiloDemonio.setDaemon(true); 

        
        //Inicio del programa
        	//Hacer visible el frame
        frame.setVisible(true); 
        	//Iniciar a los hilos
        hiloDemonio.start();
        hiloCorredor1.start();
        //hiloCorredor2.start();
    }
}