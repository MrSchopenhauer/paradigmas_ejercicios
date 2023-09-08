/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */
//HIlos demonio auxiliaireas de los usuarios, sirven para limpiar los recursos que han sido utilizados en emmemoria en el 
//BIOS etc, cuando estamos trabajando en alguna aplicacion queremos ver los procesos que se estan ejecutando
// hilo demonio son auxiliares y sirven para limpiar todo lo que se hizo
// dos tipos de hilo, el hilo usuario es el comun, el hilo demonio es un apoyo en recuperar recursos utilizados por aplicaciones
//hilo demonio, no lo ves no los defines
// bugs o gusanos que se distribuyen 
//facebook agentes que estaban dando su propio lenguaje y extraccion de infomracion de bastantes usuarios
//LEER acerca de esta historia de la informatica 
//HILOS PROCESOS QUE SE LANZAN A MILES DE USUARIOS, HILOS DEMONIO, HILOS AUXILIARES limpiar para restaurar los recursos usados 
//por hilos usuarios
//
//van a EXISTIR DURANTE LA EXISTENCIA DE HILOS USUARIO, VA A ESTAR IMPRIMIENDO LATENCIA. NO SE SINCRONIZA CON HILO USUARIO
// INDEPENDIENTE AL HILO USUARIO PERO VAN A EXISTIR PARALELELAMENTE Y EL HILO VA A EXISTIR MIENTRAS EL HILO USUARIO EXISTA
public class DaemonThread extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Hilo Demonio en ejecución");
				Thread.sleep(1000);
			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();
//CHECAR EL MENSAJE 
		} finally {
			System.out.println("Hilo Demonio Terminando"); // never called pq como no hay hilos usuario ya no hay hilos demonio 
		}
	}

}

