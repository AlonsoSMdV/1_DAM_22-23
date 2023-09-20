package productos;

public class Productos {
  private long id;
    private String nombre;
    private double precio;
    

    public Productos(String producosText){
        String[] values = producosText.split(";");
        this.id = Integer.parseInt(values[0]);
        this.nombre = values[1];
        this.precio = Double.parseDouble(values[2]);

        
    }


    public Productos(long id, String nombre,double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
      return precio;
    }

    public void setPrecio(double precio) {
      this.precio = precio;
    }


    /** equals
     * Compara dos jugadores segón su id
     * @param obj Jugador con el que comparar
     * @return Devuelve true si el objeto es igual al jugador, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
       return obj!=null && 
            obj.getClass() == this.getClass() && 
            ((Productos)obj).getId() == this.id;
    }

    /** toString
     * 
     * @return Devuelve una cadena que identifica al jugador
     */
    @Override
    public String toString() {
        return String.format(
            "id: %d, nombre: %s, precio: %d", 
            id, nombre, precio);
    }

    /** serialize
     * 
     * @return Devuelve una cadena que representa al jugador para ser serializado a disco
     */
    public String serialize(){
        return String.format("%d;%s;%d\n", id, nombre, precio);
    }
}
