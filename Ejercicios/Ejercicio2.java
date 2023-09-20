import java.util.Scanner;
public class Ejercicio2{
	public static void main(String[] args){
		System.out.print("Introduzca un número entero: ");
		Scanner sc = new Scanner(System.in);
		int valor = sc.nextInt();
		if(valor > 0)
			System.out.println("El número es positivo");
		else if (valor < 0)
			System.out.println("El número es negativo");
		else
			System.out.println("El número es neutro");
		sc.close();
	}	
}
