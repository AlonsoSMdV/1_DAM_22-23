import java.util.Scanner;
public class EjercicioBucle6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Qué factorial desea realizar? ");
		int n = sc.nextInt();
		int f = 1;
		for(int cont=1; cont<=n;cont++){
			f*=cont;
		}
		System.out.print("El factorial de "+n+" es "+f);
	}
}
