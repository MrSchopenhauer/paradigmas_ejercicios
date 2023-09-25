package ProducerConsumer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class PistaDeCarreras {
	
	public static void main (String[] args){
        JFrame frame = new JFrame("Carrera de caballos gueros");
        frame.setSize(800, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        Corredor_grafico corredorProductor = new Corredor_grafico(0, 50, 1); 
        
        ValoresDeMovimiento movimientoProductor = new ValoresDeMovimiento(corredorProductor);
        
        JPanel panel = new JPanel() {
            @Override
        	 protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 movimientoProductor.getCorredorMover().draw(g); //Mas adelante se va a tener que crear un arreglo con los corredores a agregar al programa, aqui tiene que haber un for
        	
        }};
        Thread corredorHiloProductor = new Thread(new HiloProductor(movimientoProductor,panel));
        
        panel.setBackground(Color.BLUE);
        frame.add(panel);
        frame.setVisible(true);
        
        corredorHiloProductor.run();
	} 
}
