package Carrera;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corredor {
	//Variables
	 	//Base animacion
    private BufferedImage[] sprites;
    private int currentSpriteIndex; 
    	//Coordenadas y movimiento
    private int x;
    private int y;
    public void setAsteriscos(List<JLabel> asteriscos) {
		this.asteriscos = asteriscos;
	}

	private int previousX; 
    private int previousY; 
    	//Estela que deja mientras avanza
    private List<JLabel> asteriscos = new ArrayList<>();

	//Para identificar al ganador y fin del ciclo
    private int id;
    private boolean bandera=true;

    //Getters y setters
    public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	
    public BufferedImage getCurrentSprite() {
        return sprites[currentSpriteIndex];
    }
    
    public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
	this.x = x;
}
	
	//Constructor 
	public Corredor(int x, int y, int id) {
		//Variables de posicion
        this.x = x;
        this.y = y;
        previousX = x;
        previousY = y;
        //Variables para el arreglo
        this.id = id;
        //Variables para la animacion
        currentSpriteIndex = 0;
        sprites = new BufferedImage[6]; 

        try {
        	//Para cada sprite
            for (int i = 0; i < 6; i++) {
            	//Lee el sprite .png
                String resourceName = "/Carrera/corredor" + (i + 1) + ".png";
                //El recurso que ya se ha 'desempaquetado' es utilizado
                InputStream resourceStream = getClass().getResourceAsStream(resourceName);
                //Se asigna a los sprites 
                sprites[i] = ImageIO.read(resourceStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    public void changeMyMind() {
    	//Para indicar la finalizacion de la carrera
    	this.bandera = false;
    }

    /*public void move(int deltaX) {
    	x++;

    }*/
	public void move(int deltaX, int deltaY, Graphics g, JPanel panel) {
        // Dibuja un asterisco en la posición anterior antes de mover al corredor
        if (g != null) {
        	// Color de los asteriscos
            g.setColor(Color.BLACK); 
            // Dibuja un asterisco en la posición anterior
            g.drawString("*", previousX, previousY); 
        }

        // Mover el corredor
        previousX = x;
        previousY = y;
        x += deltaX;
        y += deltaY;

        // Agregar un asterisco a la lista para su impresión
        JLabel asterisco = new JLabel("*");
        asterisco.setSize(50, 50);
        asterisco.setLocation(x, y);
        asteriscos.add(asterisco);
        panel.add(asterisco);
    }

    public void draw(Graphics g) {
        // Dibuja el sprite actual en la posición actual
        g.drawImage(getCurrentSprite(), x, y, null);
        // Avanzar al siguiente sprite
        currentSpriteIndex = (currentSpriteIndex + 1) % 6;
    }

    // Método para eliminar los asteriscos más antiguos
    public void removeOldAsteriscos(int count, JPanel panel) {
        Iterator<JLabel> iterator = asteriscos.iterator();
        while (iterator.hasNext() && count > 0) {
            JLabel asterisco = iterator.next();
            panel.remove(asterisco);
            iterator.remove();
            count--;
        }
        panel.repaint();
    }
}