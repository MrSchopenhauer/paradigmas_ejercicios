/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usosemaforos;

/**
 *
 * @author Administrador
 */
import java.util.concurrent.Semaphore;
//Se va a hacer uso de semaforos concurrentes en el mismo programa, dos semaforos concurrentes en el mismo programa 
public class p1 extends Thread  {
	//P1, es un hilo, es un constructor, tiene su semaforo
    protected Semaphore oFinP1;
    public p1(Semaphore oFinP1) {
        this.oFinP1 = oFinP1;
    }
    public void run()  {
        try {
        	//hilo1 se va a dormir
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //imprime p1
        System.out.println("P1");
        //hace el release, el numero dos indica que va a dar la se;al a dos hilos, que seran los que estan esperando la se;al
        //numero de permisos es igual al numero de hilos que esperan esa se;al 
        this.oFinP1.release(2);
    }
}

//1Recurso compartido, un hilo modifica la se;alizacion del semaforo
//2Recurso compartido, el hilo tiene semaforo con acquire en recurso compartido
//3SIn recurso compartido, acquire va funcionando 
