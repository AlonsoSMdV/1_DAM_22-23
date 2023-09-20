import java.util.Scanner;
public class Ejercicio7{
	public static void main(String[] args){
		System.out.print("Introduce tu peso: ");
		Scanner sc = new Scanner(System.in);
		float peso = sc.nextFloat();
		System.out.print("Introduce tu altura: ");
		float altura = sc.nextFloat();
		float imc = peso / (altura*altura);
		System.out.println("IMC = "+imc);
		if(imc < 18.5)
			System.out.println("Su peso es inferior al normal");
		else if(imc >= 18.5 && imc < 25)
			System.out.println("Su peso es normal");
		else if(imc >= 25 && imc < 30)
			System.out.println("Su peso es superior al normal");
		else
			System.out.println("Tiene obesidad");
		sc.close();
	}
}
