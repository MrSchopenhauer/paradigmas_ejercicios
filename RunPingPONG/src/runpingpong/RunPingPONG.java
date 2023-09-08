/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runpingpong;

/**
 *
 * @author luis_
 * 
 */

//En este programa estamos incorporando latencia 
// SIncronizacion la habra hasta 
// Latencia es una herramienta de sincronizacion, pero a un costo. EL siguiente manera de sincronizar es agregar prioridades a los ilos 

//Cambios tiempo de sincronizacion, 

class RunPingPONG implements Runnable {
  private final String word;
  private final int delay;

  RunPingPONG(String whatToSay, int delayTime) {
    word =whatToSay;
    delay=delayTime;
  }

  public void run() {
    try {
      for(int i = 0; i<10; i++) {
    	  // Por cada iteracion el hilo va a tener un tiempo de espera
          Thread.sleep(delay);
          System.out.print(word+" ");
             }
    }
    // SI sucede algo con la ejecucion del bucle pues vamos a observar esta interrupcion
    catch(InterruptedException e) {
    }
  }

  public static void main(String[] args) {
	  // Los dos hilos van a entrar al mismo tiempo, pasan los 150 o 100 milisegundos y se va a mostrar la palabra
    Runnable ping = new RunPingPONG("ping", 300);
    Runnable PONG = new RunPingPONG("PONG", 300);
    Runnable crack = new RunPingPONG("crack", 300);
    new Thread(ping).start();
    new Thread(PONG).start();
    new Thread(crack).start();
    // Aqui se juntan 
  }
  // Se eliminan los hilos y se liberan los recursos utilizados 
}
