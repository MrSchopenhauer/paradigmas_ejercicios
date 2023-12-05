package CarreraSemafo;

import java.util.Date;
import java.util.concurrent.*;

public class carreraCamino {
	
	private Semaphore semaforo;
	private Thread corredor;
	
	public void CarreraCamino() {
		semaforo = new Semaphore(1);
	}
	
	public void corriendo(String corriendo) {
		try {
					semaforo.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          
		         Long duration = (long) (Math.random() * 10000);
		         System.out.println(Thread.currentThread().getName() + ": Cola de impresión: Imprimiendo un trabajo durante " + (duration / 1000) + " seconds :: Time - " + new Date());
		         Thread.sleep(duration);
			}			
		}finally {
			semaforo.release();
			System.out.println("Corredor " + Thread.currentThread().getName()+" gano la carrera");
		}
		
	}

}
