/*Alonso Sánchez Moreno de Vega */
/*introducir numeros conn decimales usando , en el teclado en vez de . */

import java.util.Scanner;
public class Examen{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double precio;
        int cant;
        String producto = "";
        
        System.out.println("Introduzca la clase de producto que desea comprar:");
        System.out.println("1. Alimentación");
        System.out.println("2. Eletrónica");
        System.out.println("3. Farmacia");
        System.out.println("4. Moda");
        String opcion = sc.nextLine();
        switch(opcion){
            case "1":
            System.out.println("Introduzca el tipo de alimento");
            System.out.println("1. Huevos");
            System.out.println("2. Leche");
            System.out.println("3. Pan");
            System.out.println("4. Fruta");
            System.out.println("5. Verdura");
            System.out.println("6. Otros");
            String alimento = sc.nextLine();
            if((alimento.equalsIgnoreCase("1"))||(alimento.equalsIgnoreCase("2"))||(alimento.equalsIgnoreCase("3"))||(alimento.equalsIgnoreCase("4"))||(alimento.equalsIgnoreCase("5"))){
                System.out.print("Introduzca el nombre del producto: ");
                producto = sc.nextLine();
                System.out.print("Introduzca la cantidad del producto: ");
                cant = sc.nextInt();
                System.out.print("Introduzca el precio por unidad del producto: ");
                precio = sc.nextDouble();
                
                double total = (double)(precio * cant); 
                System.out.print("Factura");
                System.out.print("\n----------------------------------------------");
                System.out.printf("\nArtículo %23s",producto);
                System.out.printf("\nPrecio   %10s euros/unidad",precio);
                System.out.printf("\nCantidad %23s ",cant);
                System.out.printf("\nTotal %26s ",total);
                System.out.print("\nIVA al 4%                   "+(precio * (1+0.04)));
                System.out.print("\n-----------------------------------------------");
                System.out.printf("\nTotal con IVA %18s ",cant*(precio * (1+0.04)));
            }else if((alimento.equalsIgnoreCase("6"))){
                System.out.print("Introduzca el nombre del producto: ");
                producto = sc.nextLine();
                System.out.print("Introduzca la cantidad del producto: ");
                cant = sc.nextInt();
                System.out.print("Introduzca el precio por unidad del producto: ");
                precio = sc.nextDouble();
                double total = (double)(precio * cant); 
                System.out.print("Factura");
                System.out.print("\n----------------------------------------------");
                System.out.printf("\nArtículo %24s",producto);
                System.out.printf("\nPrecio   %10s euros/unidad",precio);
                System.out.printf("\nCantidad %24s ",cant);
                System.out.printf("\nTotal %26s ",total);
                System.out.print("\nIVA al 4%                   "+((precio * (1+0.1))-total));
                System.out.print("\n-----------------------------------------------");
                System.out.printf("\nTotal con IVA %18s ",cant+(precio * (1+0.1)));
            }
            break;
            case "2":
            System.out.print("Introduzca el nombre del producto: ");
            producto = sc.nextLine();
            System.out.print("Introduzca la cantidad del producto: ");
            cant = sc.nextInt();
            System.out.print("Introduzca el precio por unidad del producto: ");
            precio = sc.nextDouble();
            
            double total2 = (double)(precio * cant); 
            System.out.print("Factura");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\nArtículo %23s",producto);
            System.out.printf("\nPrecio   %10s euros/unidad",precio);
            System.out.printf("\nCantidad %23s ",cant);
            System.out.printf("\nTotal %26s ",total2);
            System.out.print("\nDescuento-20%             "+(precio * ( 1 - 0.2)-precio));
            System.out.printf("\nTotal con Descuento %12s ",total2-(precio-(precio * ( 1 - 0.2))));
            System.out.print("\nIVA al 214%                  "+((precio * (1+0.21))-(total2-(precio-(precio * ( 1 - 0.21))))));
            System.out.print("\n-----------------------------------------------");
            System.out.printf("\nTotal con IVA %18s ",(cant*(precio * (1+0.21))));
            break;
            case "3":
            System.out.print("Introduzca el nombre del producto: ");
            producto = sc.nextLine();
            System.out.print("Introduzca la cantidad del producto: ");
            cant = sc.nextInt();
            System.out.print("Introduzca el precio por unidad del producto: ");
            precio = sc.nextDouble();
            
            double total3 = (double)(precio * cant); 
            System.out.print("Factura");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\nArtículo %23s",producto);
            System.out.printf("\nPrecio   %10s euros/unidad",precio);
            System.out.printf("\nCantidad %23s ",cant);
            System.out.printf("\nTotal %26s %.2f","",total3);
            System.out.print("\nIVA al 4%                   "+((precio * (1+0.04))-total3));
            System.out.print("\n-----------------------------------------------");
            System.out.printf("\nTotal con IVA %18s ",cant*(precio * (1+0.04)));
            break;
            case "4":
            System.out.print("Introduzca el nombre del producto: ");
            producto = sc.nextLine();
            System.out.print("Introduzca la cantidad del producto: ");
            cant = sc.nextInt();
            System.out.print("Introduzca el precio por unidad del producto: ");
            precio = sc.nextDouble();
            if(cant>=3){
                double total4 = (double)(precio * cant); 

            System.out.print("Factura");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\nArtículo %23s",producto);
            System.out.printf("\nPrecio   %10s euros/unidad",precio);
            System.out.printf("\nCantidad %23s ",cant);
            System.out.printf("\nTotal %26s ",total4);
            System.out.printf("\nDescuento-3X2             %.2f",((-precio*2)));
            System.out.printf("\nTotal con Descuento %12s ",total4+((-precio*2)));
            System.out.print("\nIVA al 21%                 "+(precio*(1+0.21)));
            System.out.print("\n-----------------------------------------------");
            System.out.printf("\nTotal con IVA %18s ",(cant*(precio * (1+0.21))));
            }else if(cant<3){
            double total4 = (double)(precio * cant); 

            System.out.print("Factura");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\nArtículo %23s",producto);
            System.out.printf("\nPrecio   %10s euros/unidad",precio);
            System.out.printf("\nCantidad %23s ",cant);
            System.out.printf("\nTotal %26s ",total4);
            System.out.print("\nIVA al 21%                 "+((precio * (1+0.21))-total4));
            System.out.print("\n-----------------------------------------------");
            System.out.printf("\nTotal con IVA %18s ",(cant*(precio * (1+0.21))));
            break;
            }
        }
        sc.close();
    }
}