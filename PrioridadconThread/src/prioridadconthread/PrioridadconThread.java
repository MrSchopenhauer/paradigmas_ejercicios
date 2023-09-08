/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridadconthread;

/**
 *
 * @author leledezma
 */
//Genera hilos mediante la clase Thread
// SUcede exactamente lo mismo que en el caso anterior 

public class PrioridadconThread extends Thread{
    String palabra;

    public PrioridadconThread (String _palabra){
        palabra = _palabra;
    }

    @Override
    public void run (){
       for (int i=0;i<10;i++)
            System.out.println (palabra);
           }

    public static void main (String args[]){
        PrioridadconThread a1 = new PrioridadconThread("a1");
        PrioridadconThread a2 = new PrioridadconThread("a2");
        PrioridadconThread a3 = new PrioridadconThread("a3");
        PrioridadconThread a4 = new PrioridadconThread("a4");
        Thread t1 = new Thread (a1);
        Thread t2 = new Thread (a2);
        Thread t3 = new Thread (a3);
         Thread t4 = new Thread (a4);

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println ("Prioridad de t1: "+t1.getPriority()+" Nombre: "+t1.getName());
        
        t4.setPriority(Thread.MAX_PRIORITY);
        System.out.println ("Prioridad de t4: "+t4.getPriority()+" Nombre: "+t4.getName());
        
        
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println ("Prioridad de t2: "+t2.getPriority()+" Nombre: "+t2.getName());
        t3.setPriority(Thread.NORM_PRIORITY);
        System.out.println ("Prioridad de t3: "+t3.getPriority()+" Nombre: "+t3.getName());

       t1.start();
        t2.start();
        t3.start();
         t4.start();
   }
}

