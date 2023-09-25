package Carrera;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class CorredorEnMovimiento {
	private Corredor corredorProductor;
	private Corredor corredorConsumidor;
	private int x;
    private List<JLabel> asteriscos = new ArrayList<>();
    
    public CorredorEnMovimiento(Corredor corredorProductor, Corredor corredorConsumidor) {
    	this.corredorProductor = corredorProductor;
    	this.corredorConsumidor = corredorConsumidor;
    	corredorProductor.setX(this.x);
    	corredorConsumidor.setX(this.x);
    }
	
	
	

}
