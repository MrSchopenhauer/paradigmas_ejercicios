/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */


public class UserThread implements Runnable {

	public void run() {

		try {
			//Aqui esta sincronizando la ejecucion de los hilos usuarios 
			for (int i = 0; i < 5; i++) {
				System.out.println("Hilo Usuario en ejecución");
				Thread.sleep(1000);
			}
			// NO se pueden definir los hilos demonios durante el metodo run pq de lo contrario sera considerado como hilo usuario
		} catch (InterruptedException ie) {
			ie.printStackTrace();

		} finally {
			System.out.println("Hilo Usuario Terminando");
		
		}
	}

}

