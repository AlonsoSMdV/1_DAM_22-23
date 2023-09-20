package jugadores;

public class Jugador {
  private long id;
  private String nombre;
  private String apellidos;
  private String posicion;
  private long dorsal;

  public Jugador(long id, String nombre, String apellidos, String posicion, long dorsal){
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.posicion = posicion;
    this.dorsal = dorsal;
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


  public String getApellidos() {
    return apellidos;
  }
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }


  public String getPosicion() {
    return posicion;
  }
  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }
  

  public long getDorsal() {
    return dorsal;
  }
  public void setDorsal(long dorsal) {
    this.dorsal = dorsal;
  }

  @Override
  public boolean equals(Object obj) {
    
    return obj!= null && obj.getClass() == this.getClass() && ((Jugador)obj).getId()  == this.id;
  }

  @Override
  public String toString() {
      return String.format("id: %d, nombre: %s, apellidos: %s, posicion: %s, dorsal: %d", id,nombre,apellidos,posicion,dorsal);
  }
}
