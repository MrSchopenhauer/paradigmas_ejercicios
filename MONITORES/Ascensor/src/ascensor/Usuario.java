/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

/**
 *
 * @author leledezma
 */
 public class Usuario extends Thread {

    //Atributo privado
    private String nombre;
    private int piso;
    private Ascensor ascensor;
    private int[] pisos;

    //Constructor de la clase
    public Usuario(Ascensor a, String n) {
      nombre = n;
      piso = 0;
      ascensor = a;
    }

    //Constructor de la clase
    public Usuario(Ascensor a, String n, int p, int[] lp) {
      nombre = n;
      piso = p;
      ascensor = a;
      pisos = lp;
    }

    public void VerPisos() {
    	//Variable local para cada hilo, es para que se observe hilo va a tal piso
      for(int i = 0; i < pisos.length; ++i)
        System.out.println(nombre + " va al piso " + pisos[i]);
    }

    //Método que llama al ascensor para ir de un piso a otro
    //EL usuario llama al ascensor en donde esta originalmente, va a su destino, luego vuelve a llamar al ascensor, y termina por volver a llamar al ascensor como en su cola de pisos
    //los dos hilos van a estar haciendo uso del ascensor e invocandolo
    //el ascensor tiene que ubicar en que piso se encuentra, eso lo sabra de donde llego al piso destino 
    //el ultimo piso a donde llego el ascensor
    public void llamarAscensor(int destino) {
      System.out.println("El usuario " + nombre + " está esperando en el piso " + piso + " para ir al piso " + destino);
      String mensaje1 = "El usuario " + nombre + " subio en el ascensor en el piso " + piso;
      //este es el metodo del monitor, el ascensor es el monitor, tiene sus metodos para dar servicio a los usuarios. sube y baja, debe tener un metodo en el que el pueda
      //identificar quien lo llama y a que piso
      ascensor.llamar(piso, mensaje1);
      String mensaje2 = "El usuario " + nombre + " ha llegado al piso " +  destino;
      ascensor.llamar(destino, mensaje2);
      //sirve para que el ascensor sepa en donde esta, asi cuando tome una llamada va a poder decidir si va a subir o si va a bajar
      piso = destino;
    }
   

    //Método run
    @Override
    public void run() {
      for(int i = 0; i < pisos.length; ++i) {
        llamarAscensor(pisos[i]);
      }
    }
 }

