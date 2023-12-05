/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoreexample;

/**
 *
 * @author leledezma
 */
class PrintingJob implements Runnable
{
   private PrinterQueue printerQueue;
 
   public PrintingJob(PrinterQueue printerQueue)
   {
      this.printerQueue = printerQueue;
   }
 
   @Override
   public void run()
   {
      System.out.printf("%s: *Va imprimir un documento\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}
