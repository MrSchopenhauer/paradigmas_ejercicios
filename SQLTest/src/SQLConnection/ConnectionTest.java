package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
   public static void main(String[] args) throws Exception {

      // variables
      final String url = "jdbc:mysql://localhost:3306/zoo";
      final String user = "root";
      final String password = "";

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");

          // Establece la conexión
          Connection conexion = DriverManager.getConnection(url, user, password);
          Statement statement = conexion.createStatement();

          String createTableSQL = "CREATE TABLE IF NOT EXISTS Zoo(" +
          "Num_zoo INT PRIMARY KEY," +
          "Ciudad VARCHAR(30)," + "Nombre VARCHAR(30),"+"Tamanio FLOAT,"+
          "Presupuesto float,"+ "Pais VARCHAR(30))";
          statement.executeUpdate(createTableSQL);
          
          String createTableEspecie = "CREATE TABLE IF NOT EXISTS Especie(" +
          "Num_especie INT PRIMARY KEY," +
          "NomVulgar VARCHAR(30)," + "NomCient VARCHAR(30),"+"Familia VARCHAR(30),"+"PeligroExtincion BOOLEAN)";
          statement.executeUpdate(createTableEspecie);

          String createTableAnimal = "CREATE TABLE IF NOT EXISTS Animal("
          +"Num_animal INT PRIMARY KEY,"
          +"Sexo VARCHAR(10),"
          + "Nacimiento INT,"
          + "Num_zoo INT," 
          + "FOREIGN KEY (Num_zoo) REFERENCES Zoo(Num_zoo),"
          + "Num_especie INT,"
          + "PaisOrigen VARCHAR(15))";
          statement.executeUpdate(createTableAnimal);
          
          System.out.println("Tablas creadas exitosamente");
          
          String insertZoo = "INSERT IGNORE INTO Zoo (Num_zoo, Ciudad, Nombre, Tamanio, Presupuesto, Pais) " +
                  "VALUES (1, 'Toluca', 'Zacango', 1.0, 1.0, 'Mexico')";
          statement.executeUpdate(insertZoo);
          
          String insertZoo2 = "INSERT IGNORE INTO Zoo VALUES (2, 'Pachuca', 'Pachango', 1.0, 1.0, 'Mexico')";
          statement.executeUpdate(insertZoo2);
          // Comprueba si la conexión es correcta y crea tabla
          if (conexion != null) {
              System.out.println("Conexión exitosa a la base de datos MySQL");

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




/*;/*/
  
