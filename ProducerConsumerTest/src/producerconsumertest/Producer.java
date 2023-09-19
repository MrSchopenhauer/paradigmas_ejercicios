/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumertest;

/**
 *
 * @author leledezma
 */
class Producer extends Thread {
	//CUBILETE Y NUMERO QUE VA A PRODUCIR 
    private CubbyHole cubbyhole;
    private int number;

    public Producer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    @Override
    public void run() {
    	
    	//CADA HILO VA A TENER SU PROPIA I, INDICA QUE EL PRODUCTOR VA A REALIZAR SU CODIGO 10 VECES, EN DONDE LO QUE VA A HACER 
    	//VA A COLOCAR EL VALOR QUE TENGA SU CONTADOR 
        for (int i = 0; i < 10; i++) {
        	//variable local, asi que cada productor va a tener su propia variable local, unica para cada hilo
        	//lo mismo para el consumidor 
            cubbyhole.put(i);  // VARIABLE "value"
            System.out.println("Productor #" + this.number + " pone: " + i);
            try {
            	//LA LATENCIA ES PARA DARLE TIEMPO AL CONSUMIDOR A QUE CONSUMA, EL CONSUMIDOR TAMBI[EN USA LA LATENCIA. COLOCARLA EN LOS
            	//HILOS, NO EN EL RECURSO COMPARTIDO 
            	//DARLE TIEMPO DE QUE EL PRODUCTOR YA PRODUJO Y DE TIEMPO A QUE EL CONSUMIDOR CONSUMA 
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}