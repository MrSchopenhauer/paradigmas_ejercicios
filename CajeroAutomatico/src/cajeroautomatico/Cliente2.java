/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author leledezma
 */
public class Cliente2 extends Thread {
    private Cajero caja1;
    private CajeroAutomatico g2;
    private String resultStrings="\n\t\t\n";
    public Cliente2 (Cajero x, CajeroAutomatico g){
        this.caja1=x;
        g2=g;
    }

    public void run(){
        int cantidad;
        for (int i=0; i<5; i++){
            do{
                cantidad=((int)(Math.random()*1000));
            }while (cantidad<1 || cantidad>1000);
            System.out.println ("Ingresando: "+cantidad);
            resultStrings+=" Ingresando "+cantidad+"\n";
            g2.areaDer.setText(resultStrings);
            caja1.ingresar(cantidad);
            try {sleep ((int)(Math.random()*3000));}
            catch (InterruptedException e){System.err.println ("Error"+e.toString());}
        }
    }
}

