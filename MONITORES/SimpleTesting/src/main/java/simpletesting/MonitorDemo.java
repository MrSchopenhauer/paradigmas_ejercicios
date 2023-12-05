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
class MonitorDemo{
	synchronized void showMsg(String  msg){ //synchronized method  
		for(int i=1;i<=5;i++){
			System.out.println(msg);  
			try{
				Thread.sleep(500);  
			}catch(Exception e){
				System.out.println(e);
			}  
		}  
	}  
}  
