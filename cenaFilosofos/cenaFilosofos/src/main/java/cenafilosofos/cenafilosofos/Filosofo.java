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
public class Filosofo {
    private final int numeroFilosofos;
    private final boolean[] palillos;
    private int comiendo = 0;

    public Filosofo(int numeroFilosofos) {
        this.numeroFilosofos = numeroFilosofos;
        palillos = new boolean[numeroFilosofos];

        for (int i = 0; i < palillos.length; i++) {
            palillos[i] = true;
        }
    }

    public synchronized void comer(int id) throws InterruptedException {
        int palilloIzquierdo;
        
        if (id == 0) {
            palilloIzquierdo = numeroFilosofos - 1;
        } else {
            palilloIzquierdo = id - 1;
        }

        while (!palillos[id] || !palillos[palilloIzquierdo] || comiendo == numeroFilosofos - 1) {
            wait();
        }

        palillos[id] = false;
        palillos[palilloIzquierdo] = false;
        comiendo++;
        
        System.out.println("Filosofo " + id + " comiendo");
    }

    public synchronized void dejarDeComer(int id) {
        int palilloIzquierdo;

        if (id == 0) {
            palilloIzquierdo = numeroFilosofos - 1;
        } else {
            palilloIzquierdo = id - 1;
        }
        
        palillos[id] = true;
        palillos[palilloIzquierdo] = true;
        comiendo--;
        
        System.out.println("Filosofo " + id + " pensando");
        
        notifyAll();
    }
}

