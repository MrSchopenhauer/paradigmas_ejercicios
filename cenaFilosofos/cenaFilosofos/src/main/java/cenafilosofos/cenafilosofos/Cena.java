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


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Cena extends Thread{
    private final Filosofo filosofo;
    private final int id;
    
    public Cena(int id, Filosofo filosofo){
        this.id = id;
        this.filosofo = filosofo;
    }

    @Override
    public void run(){
        while(true){
            try {
                
                Thread.sleep((long) (Math.random() * 5000));
                filosofo.comer(id);
                Thread.sleep((long) (Math.random() * 5000));
                filosofo.dejarDeComer(id);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cena.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
    
}

