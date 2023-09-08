/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */
public class DaemonThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Crear hilo Demonio y ejecutarlo
		DaemonThread daemonThread = new DaemonThread();
		//aqui se especifica que es un hilo demonio, si no se hace esto no sera un hilo demonio
		daemonThread.setDaemon(true);
		daemonThread.start();

		// Crea Hilo Usuario y se ejecuta
		Thread userThread = new Thread(new UserThread());
		userThread.start();

		//pueden tener hilos demonio e hilos usuario 
	}

}

