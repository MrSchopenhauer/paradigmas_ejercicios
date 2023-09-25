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
	  System.out.println(15/4-1/4);
	  System.out.println( 15%4-1%4);
	  
	  //En este caoso el control de ruta se escribe como un dominio 
	  //Se indican como una direccion los controles de ruta
	  //Al ser computo paralelo se hacen distitnots proceso en una misma computadora, se especifica para poder enviar el menssaje 
	  //cuando en un mismo tiempo hay distintos mensajes que se envian entre distintos procesos
	  //si llega a coincidir en una misma arista de la red o conexion, se van a atorar los nodos y el problema de
	  //cuello de botella, no pueden entrar ni salir 
	  //los mensajes tienen que enviarse, como se resuelve 
	  //latencia, productor consumidor sirve para resolver mensajes o datos que coinciden en un mismo nodo
	  //8 conexo 16 nodos con adyacencia que consideran los ocho vecinos que tengan nodo, no solo los 4 conexo
	  // 4 conexo o conecta cuatro 
	  //tambien se recorren columnas y renglones y se va a tomar el renglon o la comlumna mas proxima o rpaida 
	  //el 8 conexo permite m[as rapido el envio de mensaje REFERENCIAR AL DIBUJO DE RED Y AGREGARLE LAS REDES DIAGONALES 
	  // 
  }
  // Se eliminan los hilos y se liberan los recursos utilizados 
}
