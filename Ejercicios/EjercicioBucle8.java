import java.util.Scanner;
public class EjercicioBucle8{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Altura deseada: ");
		int n = sc.nextInt();
		for(int n1=n; n1>=1;n1--){
			for(int n2=1; n2 <= n-n1; n2++){
				System.out.print(" ");
			}
			for(int n3=1; n3<=(n1*2)-1; n3++){
				System.out.print("*");
			}
		System.out.println(" ");
		} 
	}
}
