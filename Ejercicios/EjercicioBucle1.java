import java.util.Scanner;
public class EjercicioBucle1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la canidad de nº pares a mostrar: ");
		int n = sc.nextInt();
		for(int i = 0; i < n*2; i++){
			if((i % 2)==0)
				System.out.print(i+", ");
		}
	}
}
