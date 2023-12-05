/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cenafilosofos.cenafilosofos;

/**
 *
 * @author leledezma
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class CenaFilosofos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int numeroFilosofos = 6;
        
        Filosofo filosofo = new Filosofo(numeroFilosofos);
        
        for (int i = 0; i < numeroFilosofos; i++) {
            new Cena(i, filosofo).start();
        }
    }
    
}

