import java.util.Scanner;
public class EjercicioBucle2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce qué número va a querer que se operado: ");
		int n = sc.nextInt();
		for(int i = 1; i <= 10; i++){
				System.out.println(n+"*"+i+"="+n*i);
		}
	}
}
