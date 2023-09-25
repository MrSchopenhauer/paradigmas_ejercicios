package Carrera;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CorredorEnMovimiento {
	private final Corredor corredorProductor;
	private final Corredor corredorConsumidor;
	private int x;
    private boolean arranca = true;
    private JPanel panel;
    private Timer timer;
    
    public CorredorEnMovimiento(Corredor corredorProductor, Corredor corredorConsumidor, JPanel panel) {
    	this.corredorProductor = corredorProductor;
    	this.corredorConsumidor = corredorConsumidor;
    	this.panel=panel;
    	
    }
	
    public synchronized int recoger(){
        while(!arranca){
            try{
                wait();
            }catch(InterruptedException ex){}
        }
        
        arranca=false;
        corredorConsumidor.setX(x);
        notify();
        return x;
      }

      public synchronized void poner(int xInterno){
         while(arranca){
            try{
                wait();
            }catch(InterruptedException ex){}
        }
        x=xInterno;
        corredorProductor.move(x);
    	panel.repaint();
        arranca=true;
        notify();
      }
	
	

}
