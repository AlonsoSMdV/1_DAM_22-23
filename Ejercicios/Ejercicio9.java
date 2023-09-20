import java.util.Scanner;
public class Ejercicio9{
	public static void main(String[] args){
		System.out.print("Introduzca el sueldo: ");
		Scanner sc = new Scanner(System.in);
		int sueldo = sc.nextInt();
		double inc = 0.12;
		if(sueldo < 500000)
			inc = 0.15 ;
		System.out.println(inc);
		System.out.println("El aumento de sueldo es de: " + sueldo*inc);
		System.out.println("El sueldo final será de: " + (sueldo + sueldo*inc));
		sc.close();
	}
}
