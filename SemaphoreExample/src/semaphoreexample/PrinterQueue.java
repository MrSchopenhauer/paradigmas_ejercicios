/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoreexample;
//libreria para fechas y una libreria que indica el uso de lo que es un semaforo de manera concurrente CONCURRENCIA HILOS CONVIVEN EN UN MISMO ENTORNO
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author leledezma
 */
public class PrinterQueue 
{
   private  Semaphore semaphore;
   
   //UN HILO VA A ESTAR HACIENDO USO DEL SEMAFORO
   public PrinterQueue()
   {
      semaphore = new Semaphore(1);
   }
   //SE IMPRIME EL DOCUMENTO QUE SE DESEA IMPRIMIR
   public void printJob(Object document)
   {
      try
      {
    	  //TECNICA MAS MODERNA
    	  //UN HILO SE APROPIA DE LA ENTRADA DE ACCESO, TOMA LA IMPRESORA (TOMA EL RECURSO COMPARTIDO)
    	  //indica a los demas hilos que esta siendo ocupado 
    	  //no se notifica, realmente solo estan latentes porque el acceso esta bloqueado
         semaphore.acquire();
          
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": Cola de impresión: Imprimiendo un trabajo durante " + (duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      }
      catch (InterruptedException e)
      {
      }
      finally
      {
         System.out.printf("%s: El documento ha sido impreso\n", Thread.currentThread().getName());
         //EL HILO LIBERA LA IMPRESORA PARA QUE OTRO HILO LA PUEDA TOMAR
         semaphore.release();
      }
   }
}
