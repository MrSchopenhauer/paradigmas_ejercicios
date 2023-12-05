/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinsemaforos;

/**
 *
 * @author Administrador
 */
public class SinSemaforos {
    public static void main(String[] args) {
        (new Thread(new p1())).start();
        (new Thread(new p2())).start();
        (new Thread(new p3())).start();
        (new Thread(new p4())).start();
    }
}

