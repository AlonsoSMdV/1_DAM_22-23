import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca su nombre: ");
		String nombre = sc.next();
		System.out.print("Introduzca su sexo: ");
		String sexo = sc.next();
		if(sexo.equals("hombre"))
			System.out.println("Bienvenido Sr. "+nombre);
		else if (sexo.equals("mujer"))
			System.out.println("Bienvendia Sra. "+nombre);
		else
			System.out.println("Bienvenido/a Sr/a. " + nombre);
		sc.close();
	}
}
