/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridadrunnable;

/**
 *
 * @author leledezma
 */
//Genera hilos mediante la clase Runnable
// Se genera mediante implementacion de RUnnable, no de thread 
//Latencia genera retardos en la ejecucion del programa, como hacer una sincornizacion en la ejecucion de los hilos
//Recurso compartido, como hacer que distintos procesos accedan al recurso compartido sin cuello de botella, que lo hagan de manera simultanea	

public class PrioridadconRunnable implements Runnable{
    String palabra;

    public PrioridadconRunnable (String _palabra){
        palabra = _palabra;
    }

    @Override
    public void run (){
        for (int i=0;i<10;i++)
            System.out.println (palabra);
    // SI sucede algo con la ejecucion del bucle pues vamos a observar esta interrupcion
    }

    public static void main (String args[]){
    	
    	// Se estan definiendo objetos de la clase prioridad runnable, tienen como argumento su string
        PrioridadconRunnable a1 = new PrioridadconRunnable("a1");
        PrioridadconRunnable a2 = new PrioridadconRunnable("a2");
        PrioridadconRunnable a3 = new PrioridadconRunnable("a3");
        // Sirven para la construccion de hilos, NO SON HILOS EN SI MISMOS, se crean conteniendo las caracteristicas 
        Thread t1 = new Thread (a1);
        Thread t2 = new Thread (a2);
        Thread t3 = new Thread (a3);
        //
        //Antes de la ejecucion se especifican las prioridades que va a tener cada uno de ellos. EL hilo uno va a teener una prioridad maxima
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println ("Prioridad de t1: "+t1.getPriority()+"Nombre: "+t1.getName());
        //Luego lee la prioridad minima y se despliega cual es su prioridad junto a su argumento
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println ("Prioridad de t2: "+t2.getPriority()+"Nombre: "+t2.getName());
        // Tiene prioridad normal y se despliega, cuando no se especifica, los hilos tienen prioridad normal
        t3.setPriority(Thread.NORM_PRIORITY);
        System.out.println ("Prioridad de t3: "+t3.getPriority()+"Nombre: "+t3.getName());
        
        // Las prioridades deben especificarse previo al lanzamiento de los hilos, no puede especificarse durante su ejecucion, debe ser previo a su ejecuci[on
   
        // EJecucion de los ilos en el metodo run, los tres hilos van a ejecutar el metodo, cada hilo va a tener su propio contador
        t1.start();
        t2.start();
        t3.start();
        
        // No respeta las prioridades
    }
}

