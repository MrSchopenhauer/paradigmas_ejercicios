package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
   public static void main(String[] args) throws Exception {

      // variables
      final String url = "jdbc:mysql://localhost:3306/test";
      final String user = "root";
      final String password = "";

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");

          // Establece la conexión
          Connection conexion = DriverManager.getConnection(url, user, password);

          // Comprueba si la conexión es correcta y crea tabla
          if (conexion != null) {
              System.out.println("Conexión exitosa a la base de datos MySQL");

              Statement statement = conexion.createStatement();
              String createTableSQL = "CREATE TABLE IF NOT EXISTS ejemplo (" +
                      "id INT AUTO_INCREMENT PRIMARY KEY," +
                      "nombre VARCHAR(255)," +
                      "edad INT)";
              statement.executeUpdate(createTableSQL);
              System.out.println("Tabla creada exitosamente");

              conexion.close();
          }
      } catch (ClassNotFoundException e) {
          System.out.println("Error: No se encontró el controlador JDBC");
          e.printStackTrace();
      } catch (SQLException e) {
          System.out.println("Error: No se pudo establecer la conexión a la base de datos");
          e.printStackTrace();
      }
  }
}
  