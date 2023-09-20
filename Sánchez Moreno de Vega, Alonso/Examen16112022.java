import java.util.Scanner;
public class Examen16112022{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe la anchura de la carta: ");
        int ancho = sc.nextInt();
        if(ancho%2 == 0){
            System.out.print("El número ha de ser impar");

        }else{
            for (int i = 1; i <= ancho; i++) {
                System.out.print("* ");
            }
            for (int i = 2; i < ancho/2+2; i ++) {
                System.out.print("\n* ");
                for (int j = 2; j < ancho; j++) {
                    System.out.print("  ");
                }
                System.out.print("*");
            }
                System.out.println();


                for (int i = 1; i <= ancho; i++) {
                    System.out.print("* ");
                }
                for (int i = 2; i < 3; i ++) {
                    System.out.print("\n* ");
                    for (int j = 2; j < ancho; j++) {
                        System.out.print("  ");
                    }
                    System.out.print("*");
                }
                System.out.println();
                for (int i = 1; i <= ancho; i++) {
                    System.out.print("* ");
                }
        }
        sc.close();

    }
}