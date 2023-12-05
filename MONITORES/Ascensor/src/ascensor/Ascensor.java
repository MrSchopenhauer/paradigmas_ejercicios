/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

/**
 *
 * @author leledezma
 */
 public class Ascensor {
	 //monitor

    //Atributo privado
    private int piso;
    //piso ultimo destino y un booleano que indica si el ascensor esta en movimiento o esta detenido
    private boolean parado;

    //Constructor de la clase
    public Ascensor() {
      piso = 0;
      parado = true;
    }

    //Método que si dada la posición del ascensor y el piso desde el que le llaman,
    //controla si el ascensor sube o baja
    //metodo publico sincronizado, pero atributos privados
    public synchronized void llamar(int p, String mensaje) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      //Ascnesor sube o baja dependiendo de en que piso identiica que esta o se le solicita 
      if(piso > p) {
        bajar(p, mensaje);
      }
      else if(piso < p) {
        subir(p, mensaje);
      }
    }

    //Método modificador que simula la subida del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    //si se ejecuta uno, no se puede ejecutar el otro, se impide que se ejecuten ambos meotdos sincronizados al mismo tiempo
    //Se ejecuta solo un metodo 
    
    public synchronized void subir(/*Piso en donde lo llaman*/int p,/*Quien lo llama*/ String mensaje) {
      while(!parado) {
        try {
        	//Mientras no este parado el hilo esta esperando a que llegue el ascensor 
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
        ++piso;
        System.out.println("Ascensor en el piso " + piso);
      }
      parado = true;
      System.out.println(mensaje);
      notifyAll();
    }

    //Método modificador que simula la bajada del ascensor. Muestra un mensaje cuando
    //el ascensor ha llegado al destino.
    public synchronized void bajar(int p, String mensaje) {
      while(!parado) {
        try {
          wait();
        } catch (InterruptedException e) {
          return ;
        }
      }
      parado = false;
      while (piso != p) {
        --piso;
        System.out.println("Ascensor en el piso " + piso);
      }
      parado = true;
      System.out.println(mensaje);
      notifyAll();
    }

    //Método observador que muestra el piso
    public synchronized void mostrarPiso() {
      System.out.println("El ascensor está en el piso " + piso);
    }

    //Método observador que devuelve el piso
    public synchronized int piso() {
      return piso;
    }

  }

