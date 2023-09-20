import java.util.Scanner;
public class EjercicioBucle10{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Altura deseada: ");
		int n = sc.nextInt();
		boolean primo = true;
		int cont = 2; 
		while (primo && cont <= (n/2)){
			if (n % cont ==0)
			primo=false;
			cont=cont+1;
		}
		if (primo)
			System.out.print("Es primo");
		else
			System.out.print("No es primo");
	}
}
