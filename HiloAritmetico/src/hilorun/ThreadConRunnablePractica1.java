/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilorun;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leledezma    FORK ---> JOIN  MAIN CREA A T1 y A T1 ----> join
 */
class ThreadConRunnablePractica1 implements Runnable{
    int numero;
    int resultado;
    
    public ThreadConRunnablePractica1 (int _numero){
        numero = _numero;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++)              
            System.out.print(palabra);
    }
    public void run(String a) {
    	
    }
    
    public static void main(String args[]){
    	String sonIguales;
    	
    	try {
    	System.out.println("Bienvenido."+"/n"+"Deseas procesar ambas operaciones con un mismo numero? Contesta con y o n");
    	Scanner inputScanner = new Scanner(System.in);
    	sonIguales = inputScanner.next();
    	while(sonIguales != "y" || sonIguales != "n") {
    		System.out.println("Debes contestar con y o n, en minuscula");
    	}
    	}catch(InputMismatchException a) {
    		System.out.println("Debes contestar con y o n, en minuscula");
    	}

    	
    	switch(sonIguales){
    	int valorA, valorB;
    	
    	case "y":
        	try {
            	System.out.println("Que numero deseas utilizar?");
            	Scanner inputScanner = new Scanner(System.in);
            	valorA = inputScanner.hasNextInt();
            	Thread t1 = new Thread(a);
                Thread t2 = new Thread(b);
                t1.start();
                t2.start();
                System.out.print("Fin del programa principal\n");

            	}
            	catch(InputMismatchException a) {
            		System.out.println("Solo numeros enteros");
            	}
    	ThreadConRunnablePractica1 a = new ThreadConRunnablePractica1(valorA);
        ThreadConRunnablePractica1 b = new ThreadConRunnablePractica1(valorA);
    		
    		
    	case "n":
    	
    	
    	}
    
    	
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
        System.out.print("Fin del programa principal\n");
    	
    }
}
