import java.util.Scanner;

import ConnectionPool.ConnectionPool;
import productos.Productos;
import productos.ProductosService;

import java.sql.SQLException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

/** App
 * Programa que gestiona jugadores.
 */
public class App {

    //Escaner para solicitar datos
    private static Scanner sc;
    //Servicio de acceso a la base de datos para los jugadores
    private static ProductosService service;
    //Pool de conexiones a la base de datos
    private static ConnectionPool pool;

    /** inicializa
     * Inicializa el Escaner el pool y el servicio de jugadores
     */
    public static void inicializa(){
        sc = new Scanner(System.in);
        //Creamos el pool de conexiones a la base de datos
        pool = new ConnectionPool("jdbc:mysql://localhost:3306/productos","user","12345678");
        //Creamos el servicio de jugadores pasándole una conexión del pool
        service = new ProductosService(pool.getConnection());
    }

    /** finaliza
     * Liberamos las conexiones del pool
     */
    public static void finaliza(){
        if(sc!=null)
            sc.close();
        pool.closeAll();
    }

    /** mostrarMenu
     * Muestra el menú en la consola
     */
    public static void mostrarMenu(){
        System.out.println("1. Listar productos");
        System.out.println("2. Importar productos");
        System.out.println("3. Exportar productos");
        System.out.println("4. Exportar por dorsal");
        System.out.println("5. Exportar por posición");
        System.out.println("6. Salir");
    }
 
    /** leerOpcion
     * Obtiene una opción de menú desde teclado
     * @return devuelve el valor introducido
     */
    public static int leerOpcion(){
        return Integer.parseInt(sc.nextLine());
    }

    /** listarJugadores
     * Lista los jugadores de la base de datos
     */
    public static void listarJugadores(){

        System.out.println("Como desea listar los productos?\n1)Por precio\n2)Por producto");
        int opcion = leerOpcion();
        switch (opcion) {
            case 1:
                try {
                    ArrayList<Productos> productos = service.requestAll("precio", "ASC");
                    for(Productos p: productos)
                        System.out.println(p);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    ArrayList<Productos> productos = service.requestAll("nombre", "ASC");
                    for(Productos p: productos)
                        System.out.println(p);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        
            default:
                break;
        }
    }

    /** importarJugadores
     * Importa los jugadores desde un fichero de texto en la base de datos
     */
    public static void importarJugadores(){

        BufferedReader br = null;
        try {
            //Creamos un manejador de archivos apuntando al fichero
            //que contiene los jugadores
            File file = new File("productos.txt");
            //Creamos un buffer de lectura de datos que apunta
            //al fichero de jugadores
            br = new BufferedReader(new FileReader(file));   
            String line = "";
            //Leemos linea a linea el fichero de jugadores
            while((line = br.readLine())!=null){
                //Creamos o actualizamos el jugador en cuestión
                service.createOrUpdate(new Productos(line));
            } 
            br.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error mientras se importaban los datos");
        }
    }

    /** exportarJugadores
     * Exporta los jugadores de la base de datos a un fichero de texto
     */
    public static void exportarJugadores(){
        //Creamos el manejador de archivo 
        File file = new File("productos.txt");
        try {
            //Creamos el buffer de escritura en modo sobreescribir
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //Obtenemos los jugadores que hay en la base de datos
            ArrayList<Productos> productos = service.requestAll("","");
            //Para cada jugador serializamos el mismo en el archivo
            for(Productos p: productos)
                bw.write(p.serialize());
            //Cerramos el buffer de escritura
            bw.close();
        } catch (Exception e) {
            System.out.println("Ocurrión un error mientras se exportaban los datos");
        }
    }

    static public void exportarPorCriterio(String fileName, String criterio, Object valor){
        try {
            ArrayList<Productos> jugadores = null;
            if(valor.getClass()==Long.class){
                jugadores = service.query(criterio, (Long)valor);
            }
            else if (valor.getClass()==String.class){
                jugadores = service.query(criterio, (String)valor);
            }
            
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Productos j: jugadores){
                bw.write(j.serialize());
            }
            bw.close();
        } catch(Exception e){
            System.out.println("Se produjo un error al exportar por dorsal");
            System.out.println(e.getMessage());
        }
        
    }

    static public void exportarPorDorsal(){
        System.out.println("Introduce el dorsal del jugador que deseas exportar");
        Long dorsal = Long.parseLong(sc.nextLine());
        String fileName = String.format("dorsal_%d.txt", dorsal);
        exportarPorCriterio(fileName, "dorsal", dorsal);
    }

    
    static public void exportarPorPosicion(){
        System.out.println("Introduce la posición del jugador que deseas exportar");
        String posicion = sc.nextLine();
        String fileName = String.format("posicion_%s.txt", posicion);
        exportarPorCriterio(fileName, "posicion", posicion);
    }


    public static void main(String[] args) throws Exception {
        inicializa();
        int opcion = -1;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    listarJugadores();
                    break;
                case 2:
                    importarJugadores();
                    break;
                case 3:
                    exportarJugadores();
                    break;
                case 4:
                    exportarPorDorsal();
                    break;
                case 5:
                    exportarPorPosicion();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion!=6);
        finaliza();
    }
}
