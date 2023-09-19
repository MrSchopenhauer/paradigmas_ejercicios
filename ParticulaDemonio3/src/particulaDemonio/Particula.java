package particulaDemonio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//EL ESQUEMA BASICO DE LA PARTICULA LO OBTUVE DE STACKOVERFLOW
public class Particula extends JPanel{
	//Ejes y tamanio de la particula
	public int x, y;
	private int size;
	//COLOR
	private String color;
	//ANCHO DEL PANEL, ESTA OBSERVER DEL PANEL
	public int wid= getWidth();
	
	public Particula(int x, int y, int size, String color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color= color;
	
	}
	
	public void setX(int x) {
		this.x = x;
	}
	//Metodo de movimiento
	  protected void move() {
	        x += 1; 
	        if (x > getWidth()) {
	            x = 4;
	        }
	    }
	  //PINTADITA
	    protected void paintComponent(Graphics g) {
	    	if (color=="black") {
		        super.paintComponent(g);
		        g.setColor(Color.BLACK);
		        g.fillOval(x, y, size, size); 		
	    	}
	    	else {
		        super.paintComponent(g);
		        g.setColor(Color.RED);
		        g.fillOval(x, y, size, size);
	    	}
	    }
}