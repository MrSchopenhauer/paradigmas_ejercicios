/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebathreadssincro;

/**
 *
 * @author leledezma
 */
class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;

   ThreadDemo( String name,  PrintDemo pd){
       threadName = name;
       PD = pd;
   }
   @Override
   public void run() {
    synchronized(PD) {
        PD.printCount();
     }
     System.out.println("Thread " +  threadName + " existe");
   }

   @Override
   public void start ()
   {
      System.out.println("Comenzando " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}
