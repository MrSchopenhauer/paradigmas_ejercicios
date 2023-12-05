/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

/**
 *
 * @author leledezma
 */
public class HolaMundo extends Thread {
	//NUMERO DE PERMISOS PARA QUE UNO INGRESE, HACE REFERENCIA A LOS PERMISOS QUE VA A TENER UN SEMAFORO
	//OTORGA TANTOS PERMISOS COMO HILOS SERAN EJECUTADOS EN EL PROGRAMA
	
    static private Semaphore semaforo = new Semaphore(1); //se crea el semaforo
    /*static private int COUNT=0;  */
    String cadena;
    //
    public HolaMundo(String cad) {
     cadena=cad;
    }

    @Override
    public void run () {
    	//EN PRINCIPIO TODOS LOS HILOS ESPERAN, TODOS. LOS HILOS COMPITEN POR EL RECURSO
    	//COLA DE HILOS
    	//HILO INGRESA, IMPRIME Y SE SALE
    	//METODO PUBLICO SINCRONIZADO SOLO PUEDE INGRESAR UNO A LA VEZ
        semaforo.WAIT();
        System.out.println(cadena);
        semaforo.SIGNAL();
        try {
            Thread.currentThread().sleep((int)(Math.random() * 100));
        } catch (InterruptedException e){}
    }

    public static void main (String args []) {
        HolaMundo H = new HolaMundo("Hola");
        HolaMundo M = new HolaMundo("Mundo");
        HolaMundo N = new HolaMundo("Mundo nuevo");
        H.start();
        M.start();
        N.start();
    }
}


class Semaphore{
	//
    private int contador;
    public Semaphore(int n) {
        this.contador = n;
    }
    //metodo de espera o P()
    //DOS METODOS SIGNAL Y WAIT, METODOS PUBLICOS Y SINCRONIZADOS TENEMOS MAS HILOS PERO EL SEMAFORO CONTROLA EL ACCESO
    
    //ES LA SE;AL DE ESPERA PARA QUE UN SEMAFORO NO INGRESE AL RECURSO COMPARTIDO
    //METODO SINCRONIZADO, UN HILO A LA VEZ
    //ENTRAN POR DISTINTAS ETAPAS LOS HILOS, ENTRA HILO 1 AL METODO CON LA VARIABLE COMPARTIDA, ENTRA HILO 2 Y 3 Y YA VALE CERO
    
    public synchronized void WAIT(){
        while(contador == 0) {
            try {
               wait();
             } catch (InterruptedException e) {}
             //contador--;
         }//fin de while
        //CON ESA RESTA VA A INDICAR QUE INTENTEN EJECUTAR EL METODO WAIT QUE VA A VALER CERO
        contador--;
    } //fin de WAIT

    //metodo de seÃ±al o V() 
    //CASO CONTRARIO QUE SI TENGA SELAK
    //AUNQUE CONTADOR VALGA UNO, NO VAN A ENTRAR LOS TRES HILOS CON LA SE;AL, VAN A TENER QUE ESPERARSE 
    public synchronized void SIGNAL(){
        contador++;
        //NOTIFY, INDICA UN HILO AL OTRO QUE YA LIBERO, YA SALIO DEL RECURSO COMPARTIDO
        //UN HILO LE COMUNICA AL QUE ESTA EN EL WAIT, NO LE COMUNICA A LOS DOS, EL OTRO HILO ESTA EN LATENCIA
        notify();
    }
}
