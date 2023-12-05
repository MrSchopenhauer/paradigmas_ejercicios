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
class  Thread2 extends Thread{
	MonitorDemo m;  
	Thread2(MonitorDemo m){
		this.m=m;  
	}  
	public void run(){
		m.showMsg("thread2");  
	}  
} 
