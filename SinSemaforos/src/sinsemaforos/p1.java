/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinsemaforos;

/**
 *
 * @author Administrador
 */
public class p1 extends Thread {
    public void run() {
        try {
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("P1");
    }
}

