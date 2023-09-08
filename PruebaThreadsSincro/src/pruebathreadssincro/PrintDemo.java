
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebathreadssincro;

/**
 *
 * @author leledezma
 */
public class PrintDemo {
     public void printCount(){
    try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Contador   ---   "  + i );
         }
     } catch (Exception e) {
         System.out.println("Thread  interrumpido.");
     }
   }
    
}
