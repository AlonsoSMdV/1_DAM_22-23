import java.util.Scanner;
public class Ejercicio3{
	public static void main(String[] args){
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		int valor = sc.nextInt();
		if(valor >= 100 && valor <= 999)
			System.out.println("El número tiene 3 cifras");
		else
			System.out.println("El número no tiene 3 cifras");
		sc.close();
	}
}
