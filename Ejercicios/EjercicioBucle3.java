import java.util.Scanner;
public class EjercicioBucle3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca cuántos números desea sumar ");
		int n = sc.nextInt();
		int suma = 0;
		for(int i=1; i<=n;i++){
			suma+=i;
		}
		System.out.println("la suma de los "+n+" primeros números es: "+suma);
	}


}












