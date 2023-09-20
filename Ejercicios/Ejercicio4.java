import java.util.Scanner;
public class Ejercicio4{
	public static void main(String[] args){
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		System.out.print("Introduzca otro número: ");
		int num2 = sc.nextInt();
		if(num2!=0 && (num1 % num2)==0)
			System.out.println(num1 + " es múltiplo de " + num2);
		else
			System.out.println(num1 + " no es múltiplo de " + num2);
		sc.close();
	}
}
