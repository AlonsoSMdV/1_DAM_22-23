package productos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import CRUD.CRUD;

public class ProductosService implements CRUD<Productos> {
  // Conexión activa con la base de datos
  private Connection conn;

  /** JugadorService (Constructor)
   * Constructor que crea la instancia del servicio y
   * almacena la conexión a la base de datos 
   * @param conn Conexión con la base de datos
   */
  public ProductosService(Connection conn){
      this.conn = conn;
  }


  private ArrayList<Productos> _requestAll(String sql) throws SQLException{
      //Creamos el array que vamos a devolver
      ArrayList<Productos> result = new ArrayList<Productos>();
      //Construimos la consulta a realizar
      Statement statement = this.conn.createStatement();   

      // Ejectuamos la consulta
      ResultSet querySet = statement.executeQuery(sql);
      // Recorremos cada uno de los registro devueltos por la consulta
      while(querySet.next()) {
          //Obtenemos los datos del Jugador
          int id = querySet.getInt("id");
          String nombre = querySet.getString("nombre");
          double precio = querySet.getDouble("precio");
          //Añadimos el jugador al array que vamos a devolver
          result.add(new Productos(id, nombre, precio));
      } 
      //Cerramos la consulta
      statement.close();

      //Devolvemos el array de jugadores
      return result;
  }


  public ArrayList<Productos> requestAll(String sortedBy, String direction) throws SQLException{
      String sql = "SELECT id, nombre, precio FROM alimentos"+(sortedBy.length()>0?(" ORDER BY "+sortedBy+" "+direction):"");
      return this._requestAll(sql);
  }

  public Productos requestById(long id) throws SQLException{
      //Varible conteniendo el Jugador a devolver
      Productos result = null;
      //Construimos la consulta a realizar
      Statement statement = this.conn.createStatement();    
      String sql = String.format("SELECT id, nombre, precio FROM alimentos WHERE id=%d", id);
      // Ejecución de la consulta
      ResultSet querySet = statement.executeQuery(sql);
      // Recorrido del resultado de la consulta
      if(querySet.next()) {
          //Obtenemos los datos del Jugador
          String nombre = querySet.getString("nombre");
          double precio = querySet.getDouble("precio");
          //creamos el jugador y lo apuntamos a la variable de
          //retorno de este método
          result = new Productos(id, nombre, precio);
      }
      //Cerramos la consulta
      statement.close();    
      //Devolvemos el jugador
      return result;
  }

  public long createOrUpdate(Productos object) throws SQLException{
      //Obtenemos los datos del Jugador a insertar o modificar
      long id = object.getId();
      String nombre = object.getNombre();
      double precio = object.getPrecio();
      //Creamos la consulta
      Statement statement = this.conn.createStatement();    
      String sql = String.format("INSERT INTO alimentos (id, nombre, precio) VALUES ('%d', '%s', '%d')",id, nombre, precio);
      try {
          // Ejecución de la consulta
          int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
          //En el caso de que no haya registros afectados
          //Devolvemos una excepción
          if (affectedRows == 0) {
              throw new SQLException("Creating user failed, no rows affected.");
          }
      } catch (SQLException e) {
          //En el caso de que el jugador ya exista en la 
          //table entonces lo actualizamos
          if(e.getErrorCode()==1062){
              //Actualizamos el jugador con la nueva información
              this.update(object);
              //Devolvemos el identificador del jugador modificado
              return id;
          }
          else
              throw e;
      }
      // Si hemos llegado aquí es porque el jugador no existía
      try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
              //devolvemos el identificador del jugador creado
              long _id = generatedKeys.getLong(1);
              statement.close();
              return _id;
          }
          else {
              //Aquí detectamos que hemos perdido conexión con el servidor de la
              //base de datos y devolvemos una excepción
              statement.close();
              throw new SQLException("Creating product failed, no ID obtained.");
          }
      }
  }

  public long create(Productos object) throws SQLException{
      //Obtenemos los datos del Jugador a insertar
      String nombre = object.getNombre();
      double precio = object.getPrecio();

      //Creamos la consulta
      Statement statement = this.conn.createStatement();    
      String sql = String.format("INSERT INTO alimentos (nombre, precio) VALUES ('%s', '%d')", nombre, precio);
      // Ejecución de la consulta
      int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
      if (affectedRows == 0) {
          // Devolvemos una excepción si no se ha creado el jugador
          throw new SQLException("Creating product failed, no rows affected.");
      }

      //Aquí llegaremos si se ha creado satisfactoriamente el jugador
      try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
              //Devolvemos el identificador del jugador creado
              long id = generatedKeys.getLong(1);
              statement.close();
              return id;
          }
          else {
              //Aquí detectamos que hemos perdido conexión con el servidor de la
              //base de datos y devolvemos una excepción
              statement.close();
              throw new SQLException("Creating product failed, no ID obtained.");
          }
      }
  }

  public int update(Productos object) throws SQLException{
      //Obtenemos los datos del jugador para actualizar
      //en la base de datos
      long id = object.getId();
      String nombre = object.getNombre();
      double precio = object.getPrecio();
      //Creamos la consulta
      Statement statement = this.conn.createStatement();    
      String sql = String.format("UPDATE alimentos SET nombre = '%s', '%d')",id, nombre, precio);
      // Ejecución de la consulta
      int affectedRows = statement.executeUpdate(sql);
      //Cerramos la consulta
      statement.close();
      //Devolvemos excepción si ha habido un error
      //o si no se ha actualizado ningún registro
      //y en caso contrario devolvemos el número de
      //registros que se han actualizado
      if (affectedRows == 0)
          throw new SQLException("Creating product failed, no rows affected.");
      else
          return affectedRows;
  }

  public boolean delete(long id) throws SQLException{
      // Creamos la consulta
      Statement statement = this.conn.createStatement();    
      String sql = String.format("DELETE FROM alimentos WHERE id=%d", id);
      // Ejecución de la consulta
      int result = statement.executeUpdate(sql);
      // Cerramos la consulta
      statement.close();
      // Devolvemos verdadero si se ha eliminado el jugador
      // o falso en caso contrario
      return result==1;
  }

  @Override
  public ArrayList<Productos> query(String column, String value) throws SQLException {
      String sql =String.format("SELECT id, nombre, precio FROM alimentos WHERE %s='%s'", column, value);
      return this._requestAll(sql);
  }

  @Override
  public ArrayList<Productos> query(String column, long value) throws SQLException {
      String sql =String.format("SELECT id, nombre, precio FROM alimentos WHERE %s=%d", column, value);
      return this._requestAll(sql);
  }

}
