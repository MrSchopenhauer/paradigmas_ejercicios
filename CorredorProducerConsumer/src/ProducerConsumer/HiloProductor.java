package ProducerConsumer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HiloProductor extends Thread {
	private ValoresDeMovimiento movimientoProductor;
	private final JPanel panel;
	private int xProcesado;
	private Timer timer;
	private int deltaX=10;
	
	public HiloProductor(ValoresDeMovimiento movimientoProductor, JPanel panel) {
		this.movimientoProductor = movimientoProductor;
		this.panel = panel; //Podriamos agregar este panel al frame y que este sea el que vaya moviendo todo
		this.timer = new Timer(100, e-> {
	        if (movimientoProductor.getCorredorMover().getX() < 720) {
	        	//System.out.println("Estoy corriendo"+ xProcesado);
	        	xProcesado= xProcesado +1 ;
	        	movimientoProductor.getCorredorMover().setPreviousX(movimientoProductor.getCorredorMover().getX());
	        	movimientoProductor.getCorredorMover().setX(xProcesado);
	            movimientoProductor.getCorredorMover().setPreviousX(xProcesado);
	            movimientoProductor.mover();

	            panel.repaint();}});

	}   
	
	public void run() {
		timer.start();
		}
	
	
}