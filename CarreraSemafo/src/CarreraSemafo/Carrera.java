package CarreraSemafo;

public class Carrera implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: *Va imprimir un documento\n", Thread.currentThread().getName());
		
	}

}
