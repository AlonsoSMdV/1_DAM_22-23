import java.util.Scanner;
public class EjercicioBucle9{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Altura deseada: ");
		int n = sc.nextInt();
		for(int n1=1; n1<=n;n1++){
			for(int n2=1; n2 <= n; n2++){
				if(n1==1 || n1==n || n2==1 || n2==n)
					System.out.print("*");
					else
					System.out.print(" ");
				
			}
		System.out.println(" ");
		} 
	}
}
