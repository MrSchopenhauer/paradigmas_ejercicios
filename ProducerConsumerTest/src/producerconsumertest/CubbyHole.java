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
    
    // LOS METODOS SON PUBLICOS, SINCRONIZADOS Y CONTENER UNA BANDERA, PARA PRODUCTOR EN TRUE Y PARA EL OTRO FALSE 
    // PARA LOS DOS HILOS LOS VALORES DEBEN DE SER CONTRARIOS Y DEBEN TENER UNA VARIABLE COMPARTIDA
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
        notify(); // PASO DE MENSAJES EN PRODUCTOR Y CONSUMIDOR, EL PRODUCTOR NOTIFICA AL CONSUMIDOR QUE LA BANDERA HA SIDO MODIFICADA Y 
        		// QUE YA PRODUJO, CUANDO TENEMOS MAS PRODUCTORES ES NOTIFYALL, AUNQUE EN ESTA PRACTICA FUE SUFICIENTE CON EL NOTIFY
        		//AGREGAR UN THREAD SLEEP, DAR TIEMPO AL CONSUMIDOR DE QUE CONSUMA 
        		//Latencia fija, no aleatoria 
    }
}
