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
          
          String createTableRegistros = "CREATE TABLE IF NOT EXISTS Registros(" +
          "Num_registro INT PRIMARY KEY," +
          "Fecha DATE," + "Nombre VARCHAR(30),"+"Tamanio FLOAT,"+"Pais VARCHAR(30))";
          statement.executeUpdate(createTableRegistros);
          
          String createTableVisitasv_1 = "CREATE TABLE IF NOT EXISTS Visitas_1(Num_zoo INT, FOREIGN KEY(Num_zoo) REFERENCES Zoo(Num_zoo),"
          		+ "Fecha DATE, total_visitas INT)";
          statement.executeUpdate(createTableVisitasv_1);
          String insertVisitas = "INSERT IGNORE INTO Visitas_1 (Num_zoo, Fecha, total_visitas) " +
      	        "VALUES (1, '2008-07-12', 320)";
      	  statement.executeUpdate(insertVisitas);
          String insertVisitas1 = "INSERT IGNORE INTO Visitas_1 (Num_zoo, Fecha, total_visitas) " +
        	        "VALUES (1, '2008-09-22', 460)";
        	  statement.executeUpdate(insertVisitas1);
          String insertVisitas2 = "INSERT IGNORE INTO Visitas_1 (Num_zoo, Fecha, total_visitas) " +
            	        "VALUES (2, '2008-02-12', 490)";
    	  statement.executeUpdate(insertVisitas2);
          String insertVisitas3 = "INSERT IGNORE INTO Visitas_1 (Num_zoo, Fecha, total_visitas) " +
      	        "VALUES (2, '2008-03-12', 560)";
          statement.executeUpdate(insertVisitas3);
          
          /*
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
          //Registros del zoo
          String insertZoo = "INSERT IGNORE INTO Zoo (Num_zoo, Ciudad, Nombre, Tamanio, Presupuesto, Pais) " +
                  "VALUES (1, 'Toluca', 'Zacango', 1.0, 1.0, 'Mexico')";
          statement.executeUpdate(insertZoo);
          String insertZoo2 = "INSERT IGNORE INTO Zoo VALUES (2, 'Pachuca', 'Pachango', 1.0, 1.0, 'Mexico')";
          statement.executeUpdate(insertZoo2);
          String insertZoo3 = "INSERT IGNORE INTO Zoo VALUES (3, 'Tenancingo', 'Tarranango', 1.0, 1.0, 'Mexico')";
          statement.executeUpdate(insertZoo3);
          String insertZoo4 = "INSERT IGNORE INTO Zoo VALUES (4, 'New York', 'Central', 1.0, 1.0, 'Estados Unidos')";
          statement.executeUpdate(insertZoo4);
          String insertZoo5 = "INSERT IGNORE INTO Zoo VALUES (5, 'Cuernavaca', 'Zoo Cuerna', 300.0, 490.0, 'Mexico')";
          statement.executeUpdate(insertZoo5);
          String insertZoo6 = "INSERT IGNORE INTO Zoo VALUES (100, 'Cuernavaca', 'Zoo Cuerna', 300.0, 490.0, 'Mexico')";
          statement.executeUpdate(insertZoo6);
          
          //Registros de Especie 
          String insertEspecie5 = "INSERT IGNORE INTO Especie VALUES (1, 'Lobo', 'Canis Lupus', 'Canis', false)";
          statement.executeUpdate(insertEspecie5);
          String insertEspecie6 = "INSERT IGNORE INTO Especie VALUES (2, 'Tigre', 'Bengalis Tigerus', 'Bengalis', false)";
          statement.executeUpdate(insertEspecie6);
          String insertEspecie7 = "INSERT IGNORE INTO Especie VALUES (3, 'Chinche', 'Chincherus UNAMSIS', 'UNAMSIS', false)";
          statement.executeUpdate(insertEspecie7);
          String insertEspecie8 = "INSERT IGNORE INTO Especie VALUES (4, 'Aguila Mexicana', 'Aguilus terraris', 'Terraris', true)";
          statement.executeUpdate(insertEspecie8);
          String insertEspecie9 = "INSERT IGNORE INTO Especie VALUES (5, 'Lobo Mexicano', 'Canis Lupus M', 'Canis', true)";
          statement.executeUpdate(insertEspecie9);
          
          //Registros de animal
          String insertAnimal9 = "INSERT IGNORE INTO Animal (Num_animal, Sexo, Nacimiento, Num_zoo, Num_especie, PaisOrigen) " +
        	        "VALUES (1, 'Female', 20220819, 1, 1, 'China')";
        	statement.executeUpdate(insertAnimal9);

        	String insertAnimal10 = "INSERT IGNORE INTO Animal (Num_animal, Sexo, Nacimiento, Num_zoo, Num_especie, PaisOrigen) " +
        	        "VALUES (2, 'Female', 20220819, 2, 2, 'Mexico')";
        	statement.executeUpdate(insertAnimal10);
        	String insertAnimal11 = "INSERT IGNORE INTO Animal (Num_animal, Sexo, Nacimiento, Num_zoo, Num_especie, PaisOrigen) " +
        	        "VALUES (3, 'Male', 20230819, 3, 1, 'Mexico')";
        	statement.executeUpdate(insertAnimal11);
        	String insertAnimal12 = "INSERT IGNORE INTO Animal (Num_animal, Sexo, Nacimiento, Num_zoo, Num_especie, PaisOrigen) " +
        	        "VALUES (4, 'Male', 20230802, 4, 3, 'Mexico')";
        	statement.executeUpdate(insertAnimal12);
        	String insertAnimal13 = "INSERT IGNORE INTO Animal (Num_animal, Sexo, Nacimiento, Num_zoo, Num_especie, PaisOrigen) " +
        	        "VALUES (5, 'Female', 20220902, 5, 2, 'Mexico')";
        	statement.executeUpdate(insertAnimal13);
        	*/
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

// Execute the SQL query
// String ordenado1 = "SELECT * FROM Zoo ORDER BY Nombre DESC";
//ResultSet resultSet = statement.executeQuery(ordenado1);

// Para total visitas SELECT Zoo.Nombre, SUM(Visitas.total_visitas) AS VisitasTotales FROM Zoo INNER JOIN Visitas ON Zoo.num_zoo = Visitas.num_zoo GROUP BY Zoo.Nombre;
// Para un INSERT INSERT INTO `Visitas_1`(`Num_zoo`, `Fecha`, `total_visitas`) VALUES ('[value-1]','[value-2]','[value-3]') 



/*;/*/
  
