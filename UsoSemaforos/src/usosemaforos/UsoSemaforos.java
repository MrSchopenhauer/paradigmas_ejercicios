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
public class UsoSemaforos {
	//SOlo dos porque van a revisarse el estado de estos semaforos
    protected static Semaphore oFinP1,oFinP3;
    public static void main(String[] args) {
    	//EL numero de permiso es de cero
         oFinP1 = new Semaphore(0,true);
         oFinP3 = new Semaphore(0,true);
         
         //HIlo uno se crea con un argumento su propio semaforo
         (new Thread(new p1(oFinP1))).start();
         //HIlo dos, su argumento es el semaforo del 1 del 3 porque va arevisar esos semaforos
         (new Thread(new p2(oFinP1,oFinP3))).start();
         (new Thread(new p3(oFinP3))).start();
         //Cuatro revisa el 1 y tres, dos semaforos como argumentos 
         (new Thread(new p4(oFinP1,oFinP3))).start();
         
    }
}

