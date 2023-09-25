package ProducerConsumer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Corredor_grafico {

	private int x;
	private int y;
	private BufferedImage img; //Para hacer efectivo el sprite hay que cambiar esto a un arreglo
	private int id;
    private int previousX; 
    private int previousY;
    
    public int getPreviousX() {
		return previousX;
	}

	public void setPreviousX(int previousX) {
		this.previousX = previousX;
	}

	public void setX(int nuevaX) {
		this.x=nuevaX;
        previousX = x;
        previousY = y;
	}
	
	public int getX() {
		return x;
	}
	
	public Corredor_grafico(int x, int y, int id) {
		this.x=x;
		this.y=y;
		this.id=id;
		
        try {
            String resourceName = "/ProducerConsumer/corredor1.png";
            InputStream resourceStream = getClass().getResourceAsStream(resourceName);
			this.img = ImageIO.read(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
				}

	}
	

	
	
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);

    }
}
