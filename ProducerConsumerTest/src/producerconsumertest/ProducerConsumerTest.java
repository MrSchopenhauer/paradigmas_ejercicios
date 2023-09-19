 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumertest;

/**
 *
 * @author leledezma
 */
class ProducerConsumerTest {
	//BASES DE DATOS, NO PUEDES HACER COSAS CONTRARIAS AL MISMO TIEMPO, O LEES O ESCRIBES, ELEVADOR O SUBE O BAJA
	//SEMAFOROS ES UNA ESTRUCTURA BINARIA 
	// EL recurso compartido va a indicar como sera accesado
	//siempre debe ingresar primero el productor
    public static void main(String[] args) {
    	//C ES LO PRODUCIDO??? NO, CUBBY HOLE ES EL RECURSO COMPARTIDO
        CubbyHole c = new CubbyHole();
        // EL UNO SE REFIERE A QUE ES EL PRODUCTOR UNO, INDICAR DE QU[E CONSUMIDOR O PRODUCTOR ERES, INDICA QUE ES EL PRODUCTOR 1
        Producer p1 = new Producer(c, 1);
        Producer p2 = new Producer(c, 2);
        //Producer p3 = new Producer(c,3);
        Consumer c1 = new Consumer(c, 1);
        Consumer c2 = new Consumer(c, 2);
        Consumer c3 = new Consumer(c,3);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
        c3.start();
        
    }
}
