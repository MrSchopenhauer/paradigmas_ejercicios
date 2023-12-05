package carreraSemaforos;


public class Corredor implements Runnable{

   private AcuerdoPrevio acuerdoPrevio;
	   
   public Corredor(AcuerdoPrevio acuerdoPrevio)
   {
	      this.acuerdoPrevio = acuerdoPrevio;
   }
	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
	      System.out.printf("%s: *Va a comenzar a correr\n", Thread.currentThread().getName());
	      acuerdoPrevio.trabajoCarrera(new Object());
		
	}

}
