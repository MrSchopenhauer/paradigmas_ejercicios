package numerosprimos;
import java.lang.Math.*;
//commited, if a particular version of a file is in the git directory, staged modified and added to the staging area, modified change since it wa checked out but has not been staged
//git clone 'SSH URL'
//git remote -v 
//git add 'filename', staging area
//git commit -m "add filename"
//git log
//git push, update
public class NumerosPrimos {	
	public static void main(String[] args) {
		int contador = 0;
		double residuo = 1;
		while (true) {
			contador++;
			switch(contador){
			case 1:
				break;
			case 2:
				System.out.println(2);
				break;
			case 3:
				System.out.println(3);
				break;
			default:
				if(contador%2==0 || contador%3==0 || contador%5==0) {
					break;
				}else{
					double raizContador = Math.sqrt(contador);
					raizContador = Math.round(raizContador);
					for(double i = raizContador; i != 1.0;i = i-1){
						 residuo = contador%i;
						if(residuo==0) {
							break;
						}
					}
					if(residuo != 0) {
					System.out.println(contador);
					}
				}
			}
		}	
	}
}
