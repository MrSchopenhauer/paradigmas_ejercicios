package ProducerConsumer;

import javax.swing.Timer;

public class ValoresDeMovimiento {
	private int xProcesamiento=0;
	private boolean accionador=false;
	private final Corredor_grafico corredorMover;

	
	public Corredor_grafico getCorredorMover() {
		return corredorMover;
	}
	
	public ValoresDeMovimiento(Corredor_grafico corredorMover) {
		this.corredorMover = corredorMover;
	}
	
	public synchronized int copiar() {
		while(!accionador) {
			 try{
		            wait();
		        }catch(InterruptedException ex){}
		    }
		    accionador=false;
		    notify();
			return xProcesamiento;
		  }
	
	public synchronized void mover() {
		while(accionador) {
			try {
				wait();
			}catch(InterruptedException ex) {}
		    System.out.print("Estoy corriendo"+xProcesamiento);
			accionador=true;
			notify();
			
		}
	}

}
