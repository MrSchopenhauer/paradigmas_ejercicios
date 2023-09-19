package particulaDemonio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Particula extends JPanel{
	//Ejes y tamanio de la particula
	public int x, y;
	private int size;
	private String color;
	public int wid= getWidth();
	public int id =0;

	
	public Particula (int x, int y, String color, int id) {
		this.x = x;
		this.y = y;
		
	}
	
    public void actualizar(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
	
	public Particula(int x, int y, int size, String color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color= color;
	
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	  protected void move() {
	        x += 1; // Partícula se mueve de izquierda a derecha
	        if (x > getWidth()) {
	            x = 4;
	        }
	    }
	  
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