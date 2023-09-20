import java.util.Scanner;
public class Ejercicio10{
	public static void main(String[] args){
		System.out.print("Introduce el número de zapatos a comprar: ");
		Scanner sc = new Scanner(System.in);
		int cantidad = sc.nextInt();
		int descuento = 0;
		if(cantidad > 30)
			descuento = 40;
		else if(cantidad > 20)
			descuento = 20;
		else if(cantidad > 10)
			descuento = 10;
		System.out.println("Descuento aplicado: "+descuento+"%");
		System.out.println("El precio sin descuento es: "+cantidad*80);
		System.out.println("Total con descuento: " +  cantidad*80*(1 - descuento/100));
		sc.close();
		
	}
}
