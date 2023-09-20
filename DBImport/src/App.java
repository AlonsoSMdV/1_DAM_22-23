import java.util.Scanner;

import com.sun.jdi.connect.spi.Connection;

public class App {
    public static Scanner sc;
    private static 
    static void inicializar(){//Iniciar Scanner
        sc = new java.util.Scanner(System.in);
    }
    protected static void finalizar(){//Fin Scanner
        if(sc!=null)
            sc.close();
        pool.closeAll();
    }
    public static void mostrarMenu(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
