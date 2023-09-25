/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author leledezma
 */
import javax.swing.JOptionPane;

public class Cajero {
    private int cantidad;
    public Cajero(){
        cantidad=10000;
    }

    public synchronized void retira(int x){
        while (cantidad-x <=0)
            try {
                wait();
            }catch (InterruptedException e){
                JOptionPane.showMessageDialog(null,"No hay Dinero","Error",JOptionPane.WARNING_MESSAGE);
            }
            cantidad=cantidad-x;
            notify();
    }

    public synchronized void ingresar(int x){
        while (cantidad+x>=10000)
        try {
            wait();
        }
        catch (InterruptedException e){
            JOptionPane.showMessageDialog(null,"No hay Dinero","Error",JOptionPane.WARNING_MESSAGE);
        }
        cantidad=cantidad+x;
        notify();
    }

    public int RegresaCantidad(){
        return cantidad;
    }
}

