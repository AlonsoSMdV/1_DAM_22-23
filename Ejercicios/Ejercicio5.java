import java.util.Scanner;

public class Ejercicio5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int num = sc.nextInt();
		if( (num % 10)==5 || (num % 10)==-5)
			System.out.println(num + " termina en 5");
		else
			System.out.println(num + " no termina en 5");
		sc.close();
	}
}
