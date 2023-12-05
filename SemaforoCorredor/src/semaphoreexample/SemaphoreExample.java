/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoreexample;

/**
 *
 * @author leledezma
 */
public class SemaphoreExample 
{
   public static void main(String[] args)
   {
      PrinterQueue printerQueue = new PrinterQueue();
      //Arreglo de diez hilos
      Thread thread[] = new Thread[10];
      //Los diez hilos se crean y se crea el arreglo de los diez hilos
      for (int i = 0; i < 10; i++)
      {
    	  //vector donde cada localidad son 10 hilos y cada hilo tiene como argumento su cola de impresion 
         thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
      }
      for (int i = 0; i < 10; i++)
      {
         thread[i].start();
     }
   }
}
