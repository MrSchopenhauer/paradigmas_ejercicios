/*]
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilorun;
import java.util.Scanner;

/**
 *
 * @author Antonio Rivera con template de Ledezma    FORK ---> JOIN  MAIN CREA A T1 y A T1 ----> join
 */

class ThreadConRunnablePractica1 implements Runnable{
    long numero;
    boolean whoIsWho;
    
    public ThreadConRunnablePractica1 (long _numero, boolean _whoIsWho){
        numero = _numero;
        whoIsWho = _whoIsWho;
    }
    
    @Override
    public void run(){
    	long resultadoSuma=numero;
    	long resultadoFactorial=numero;
    	
    	// Se designa la accion que hara cada hilo a traves de operador booleano
    	if (whoIsWho) {
    		
    		//se define la operacion de suma si el hilo es verdadero
    		for(long i= numero; i > 0;i = i-1) {
    			resultadoSuma = resultadoSuma + i-1;
    		}
    		
    	System.out.println("El resultado de la suma es: "+ resultadoSuma);
    		
    	}else{
    		
    		//se define la operacion de factorial si el hilo es falso
    		for(long i= numero; i > 1 ;i--) {
    			resultadoFactorial = resultadoFactorial*(i-1);
    		}
    		
    		System.out.println("El resultado del factorial es: "+ resultadoFactorial);
    	}
    
    }
    
    public static void main(String args[]){
    	System.out.println("Cual numero quieres procesar? >>");
    	Scanner enteroScanner = new Scanner(System.in);
    	long respuesta = enteroScanner.nextInt();
    	
        ThreadConRunnablePractica1 a = new ThreadConRunnablePractica1(respuesta,false);
        ThreadConRunnablePractica1 b = new ThreadConRunnablePractica1(respuesta,true);
        
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
        System.out.print("Fin del programa principal\n");
        enteroScanner.close();
    }
}

