import java.util.Scanner;
public class Ejercicio8{
	public static void main(String[] args){
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		System.out.print("Introduzca otro número: ");
		int num2 = sc.nextInt();
		System.out.print("Introduzca otro número: ");
		int num3 = sc.nextInt();
		if(num1 <= num2 && num1 <= num3){
			if(num2 <= num3)
				System.out.print(num1 + " <= " + num2 + " <= " + num3);
			else
				System.out.print(num1 + " <= " + num3 + " <= " + num2);
		}
		else if(num2 <= num1 && num2 <= num3){
			if(num1 <= num3)
				System.out.print(num2 + " <= " + num1 + " <= " + num3);
			else
				System.out.print(num2 + " <= " + num3 + " <= " + num1);
		}
		else if(num3 <= num1 && num3 <= num2){
			if(num1 <= num2)
				System.out.print(num3 + " <= " + num1 + " <= " + num2);
			else
				System.out.print(num3 + " <= " + num2 + " <= " + num1);
		}
		sc.close();	
	}
}
