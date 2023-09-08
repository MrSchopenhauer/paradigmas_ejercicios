package particle;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Particle extends JPanel {
	    private int x;
	    private int y;
	    private int size;
	    private Timer timer;

	    public Particle(int x, int y, int size) {
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        timer = new Timer(10, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                move();
	                repaint();
	            }
	        });
	        timer.start();
	    }

	    private void move() {
	        x += 1; // Partícula se mueve de izquierda a derecha
	        if (x > getWidth()) {
	            x = 4;
	        }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setColor(Color.BLACK);
	        g.fillOval(x, y, size, size);
	    }

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Particle App");
	        frame.setSize(800, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new CardLayout());

	        Particle particleWithTrail = new Particle(100, 100, 10);
	        frame.add(particleWithTrail, BorderLayout.WEST);
	        
	       // Particle particleCleaner = new ParticleCleaner(100, 200, 20, particleWithTrail);
	        //frame.add(particleCleaner, BorderLayout.CENTER);

	        frame.setVisible(true);
	    }
	}

	class ParticleCleaner extends Particle {
	    private Particle particleToClean;

	    public ParticleCleaner(int x, int y, int size, Particle particleToClean) {
	        super(x, y, size);
	        this.particleToClean = particleToClean;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0, getWidth(), getHeight());

	        // Limpia la estela de la partícula
	        particleToClean.repaint();
	    }
	}
