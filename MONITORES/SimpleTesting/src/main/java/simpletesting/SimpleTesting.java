/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesting;

/**
 *
 * @author leledezma
 */
public class SimpleTesting{
	public static void main(String args[]){
		MonitorDemo obj = new MonitorDemo();  
		Thread1 t1 = new Thread1(obj);  
		Thread2 t2 = new Thread2(obj);  
		t1.start();  
		t2.start();  
	}  
}  
