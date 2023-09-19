package particulaDemonio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ThreadCamino implements Runnable {
	//Variables de tipo particula
    private final Particula particulaDemonio;
    private final JPanel usuarioContenedor;
    
    //Varibales para hastag
    private List<JLabel> hashtags = new ArrayList<>();
    private int hashtagsIndex = 0;
    private int xPosicion = 0; 
    private int hashtagsEliminar=0; 
    
    //Variables temporal y booleana
    private Timer timer;
    private volatile boolean running = true;


    public ThreadCamino(JPanel usuarioContenedor, Particula particulaDemonio) {
    	//Inyeccion de dependencias 
        this.usuarioContenedor = usuarioContenedor;
        this.particulaDemonio = particulaDemonio;

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xPosicion < 780) {
                	//Movimiento del hashtag
                    xPosicion += 1; 
                    
                    //Para prevenir un crecimiento exponencial de la eliminacion del camino
                    int prevenimss = 0;
                    
                //AQUI VIENE EL CICLO DE IMPRESION QUE VA JUGANDO A SOY MENOR QUE EL VL TIMER O SOY MAYOR y al mismo tiempo cada ciclo va
                    //haciendo que un HASHTAG SE REIMPRIMA
                    //Si el index es menor al tamanio, vamos a obtener todo el index dentro del Jlabel, para actualizar
                    if (hashtagsIndex < hashtags.size()) {
                        JLabel hashtag = hashtags.get(hashtagsIndex);
                        //Ubicacion dentro del panel de lo que se reimprimira
                        hashtag.setLocation(xPosicion, 20); 
                        hashtag.repaint();
                    } else {
                    	//Si son de igual tamanio, entonces vamos a colocar un gato nuevo que tendra por reimpreso todo lo anterior
                        JLabel hashtag = new JLabel("#");
                        hashtag.setSize(10, 10);
                        //La ubicacion que tendra este hastag
                        hashtag.setLocation(xPosicion, 20); 
                        //Se agrega este hastag a la lista para que se pueda reimprimir en la siguiente iteracion
                        hashtags.add(hashtag);
                        //Se agrega el hastag actual al panel 
                        usuarioContenedor.add(hashtag);
                    }
                    //CADA VEZ QUE SE REPITE ESTO SE AUMENTA EL INDEX Y SE REPINTA
                    hashtagsIndex++;
                    usuarioContenedor.repaint();

                    // EN CUANTO EL HILO DEMONIO COMIENZA A MOVERSE COMIENZAN A ELIMINARSE LOS HASHTAGS
                    if (particulaDemonio.x != 0) {
                    	//RESTA PARA EVITAR EL CRECIMIENTO EXPONENCIAL
                    	prevenimss=particulaDemonio.x-1;
                        hashtagsEliminar=particulaDemonio.x-prevenimss;
                      //ELIMINAMOS DE ADELANTE PARA ATRAS
                        removeFirstHashtags(hashtagsEliminar);
                    }
                } else {
                	//PARAMOS EL TIMER CUANDO LA POSICION YA SUPERO LO INDICADO
                    ((Timer) e.getSource()).stop();
                    running = false;
                }//ELSE
            }//ACCION REALIZADA
        }//ACTION LISTENER
        );
    }//FIN DEL METODO

    //CLASICO METODO RUN DEL HILO
    public void run() {
        try {
        	//MIENTRAS EL HILO EXISTA, INICIA EL TIMER DEL HILO
            while (running) {
                timer.start();
            }
        } finally {
        	//CUANDO EL HILO MUERE, IMPRIME FINALIZADO
            System.out.println("Finalizado");
        }
    }

    // METODO PARA ELIMINAR LOS HASHTAGS BASE EN UN METODO DE STACKOVERFLOW 
    private void removeFirstHashtags(int count) {
        Iterator<JLabel> iterator = hashtags.iterator();
        while (iterator.hasNext() && count > 0) {
            JLabel hashtag = iterator.next();
            usuarioContenedor.remove(hashtag);
            iterator.remove();
            count--;
        }
        usuarioContenedor.repaint();
    }
}