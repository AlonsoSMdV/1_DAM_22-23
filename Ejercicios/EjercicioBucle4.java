import java.util.Scanner;
public class EjercicioBucle4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca cuántos números desea sumar ");
		int n = sc.nextInt();
		int suma = 0;
		int valor = 0;
		for(int i=1; i<=n;i++){
			System.out.print("Valor: ");
			valor = sc.nextInt();
			suma+=valor;
		}
		System.out.println("la media de los "+n+" primeros números es: "+(suma/n));
	}
}
