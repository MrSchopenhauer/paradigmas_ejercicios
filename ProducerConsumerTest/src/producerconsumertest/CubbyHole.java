/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumertest;

/**
 *
 * @author leledezma
 */
class CubbyHole {
    private int contents;         // this is the condition variable.
    private boolean available = false;
    // NO SE COLOCA SINCRONIZACION PARA SINCRONIZAR LOS HILOS, EL OBJETO COMPARTIDO ESTA INDICANDO COMO VA A SER ACCESADO
    // METODO DE LEER O DE COLOCAR O DE PRODUCIR, CONSUMIDOR PRODUCTOR, 
    public synchronized int get() {    //CONSUMIDOR
    	
    	//VERIFICAR SI EL RECURSO COMPARTIDO ESTA DISPONIBLE, EN SU METODO ESPECIFICA COMO SERA ACCESADO
    	// DEBE SER PUBLICO POR QUE VAN A TENERSE MPAS DE UN PRODUCTOR O CONSUMIDOR
        while (available == false) {
            try {
            	//EL HILO CONSUMIDOR ESTARA ESPERANDO, EL PRODUCTOR ESTA PRODUCIENDO Y COLOCA UN NUMERO EN LA LOCALIDAD DEL VECTOR
            	//ESTO SOLO SI LA VANDERA ESTA EN FALSO 
            	//ESTA VARIABLE ES PRIVADA PARA QUE NO PUEDA SER MODIFICADA POR DISTINTOS HILOS EN DISTINTOS MOMENTOS 
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notify();
        return contents;
    }

    public synchronized void put(int value) {    //PRODUCTOR
        while (available == true) {
            try {
            	//SI LA VARIABLE ESTA EN FALSO, EL PRODUCTOR CHAMBEA 
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        notify();
    }
}
