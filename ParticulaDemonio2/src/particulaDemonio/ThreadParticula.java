package particulaDemonio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ThreadParticula implements Runnable {
    public Particula particulaClase;
    public final JProgressBar progreso;
    public JInternalFrame usuarioContenedor;
    private List<JLabel> hashtags = new ArrayList<>(); // Use JLabels to display hashtags
    public int hashtagsIndex = 0;
    private Timer timer;
    public volatile boolean running = true;
    private int hashtagOffset = 0; // Added hashtag offset

    public ThreadParticula(Particula particulaUsuario, JProgressBar progreso, JInternalFrame usuarioContenedor) {
        this.particulaClase = particulaUsuario;
        this.progreso = progreso;
        this.usuarioContenedor = usuarioContenedor;

        timer = new Timer(10, new ActionListener() {
            int progressValue = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (particulaClase.x < 780) {
                    particulaClase.move();
                    progressValue = particulaClase.x;
                    progreso.setValue(progressValue);

                    if (hashtagsIndex < hashtags.size()) {
                        JLabel hashtag = hashtags.get(hashtagsIndex);
                        hashtag.setLocation(particulaClase.x + hashtagOffset, particulaClase.y); // Add the offset
                        hashtag.repaint();
                    } else {
                        JLabel hashtag = new JLabel("#");
                        hashtag.setSize(10, 10); // Set the size of the hashtag
                        hashtag.setLocation(particulaClase.x + hashtagOffset, particulaClase.y); // Add the offset
                        hashtags.add(hashtag);
                        usuarioContenedor.add(hashtag);
                    }
                    hashtagsIndex++;
                    usuarioContenedor.repaint();
                    hashtagOffset += 10; // Adjust the offset as needed for your desired spacing
                } else {
                    ((Timer) e.getSource()).stop();
                    running = false;
                }
            }
        });
    }

    public void run() {
        try {
            while (running) {
                timer.start();
            }
        } finally {
            System.out.println("Finalizado");
        }
    }

    public void stopThread() {
        running = false;
        Thread.currentThread().interrupt();
    }
}