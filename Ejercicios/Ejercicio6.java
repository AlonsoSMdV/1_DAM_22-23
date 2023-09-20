import java.util.Scanner;
public class Ejercicio6{
	public static void main(String[] args){
		System.out.print("Introduce un número: ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		System.out.print("Introduce otro número: ");
		int num2 = sc.nextInt();
		System.out.println("Introduce la operación: ");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		int op = sc.nextInt();
		if(op==1)
			System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		else if(op==2)
			System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		else if(op==3)
			System.out.println(num1 + " x " + num2 + " = " + (num1*num2));
		else if(op==4 && num2!=0)
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		else
			System.out.println("Operación no permitida");
		sc.close();
		
	}
}
