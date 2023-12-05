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
public class p2 extends Thread  {
    protected Semaphore oFinP1;
    protected Semaphore oFinP3;
    public p2(Semaphore oFinP1,Semaphore oFinP3) {
        this.oFinP3 = oFinP3;
        this.oFinP1 = oFinP1;
    }
    
    @Override
    public void run()  {
        try {
        	//acquire, lee la se;al , mientras estan esperando el dos y el cuatro, cuando el uno y el dos se liberan se ejecuta
        this.oFinP1.acquire();
        this.oFinP3.acquire();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("P2");
        //no hace release pq no tiene semaforos, solo esta revisando
    }
}

