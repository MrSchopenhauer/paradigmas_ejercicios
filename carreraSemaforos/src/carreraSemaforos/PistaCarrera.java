package carreraSemaforos;
public class PistaCarrera {
	
	public static void main(String[] args) {
		AcuerdoPrevio acuerdoPrevio = new AcuerdoPrevio();
		
		Thread thread[] = new Thread[2];
	      for (int i = 0; i < 2; i++)
	      {
	   
	         thread[i] = new Thread(new Corredor(acuerdoPrevio), "Thread " + i);
	      }
	      for (int i = 0; i < 2; i++)
	      {
	         thread[i].start();
	     }
	}

}
