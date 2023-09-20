package ConnectionPool;

 import java.sql.Connection;
 import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionPool {
  ArrayList<Connection> conns = new ArrayList<Connection>();
  private String url;
  private String user;
  private String password;

  public ConnectionPool(String url, String user, String password){
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public Connection getConnection(){
    Connection _conn = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      _conn = DriverManager.getConnection(this.url, this.user, this.password);
      this.conns.add(_conn);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return _conn;
  }
  public void closeAll() {
    for(Connection conn : this.conns){
      try {
        if(conn!=null){
          conn.close();
      }
      } catch (Exception e) {
        System.out.println(e.equals(e));
      }

    }
  }
}
