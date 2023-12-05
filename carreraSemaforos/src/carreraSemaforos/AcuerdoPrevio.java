package carreraSemaforos;

import java.util.concurrent.Semaphore;
//RECURSO COMPARTIDO

public class AcuerdoPrevio {
	
	private Semaphore semaforo;
	
    public AcuerdoPrevio() {
        acuerdoPrevio(); // Llama al método para inicializar el semáforo
    }
	
	public void acuerdoPrevio() {
		semaforo = new Semaphore(1);
	}
	
	   public void trabajoCarrera(Object document)
	   {
	      try
	      {
	         semaforo.acquire();
	          
	         Long duration = (long) (Math.random() * 10000);
	         System.out.println(Thread.currentThread().getName() + " esta corriendo");
	         Thread.sleep(duration);
	      }
	      catch (InterruptedException e)
	      {
	      }
	      finally
	      {
	         System.out.printf("%s: Ha llegado a la meta el corredor\n", Thread.currentThread().getName());
	         semaforo.release();
	      }

 }
}