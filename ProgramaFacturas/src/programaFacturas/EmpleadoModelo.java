package programaFacturas;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class EmpleadoModelo {
	private Statement statement;
	private int intArray[];
	
	//Para crear los registros 
	String nomArrayFixed [] = {"Juan Jose","Jorge Jose","Paco Jose","Luis Jose","Xanat Maria","Pedro Jo","Nino Jose","Jose Jose","Manuel Jose","Vicente", "Sofia", "Carmen", "Aleli", "Berta","Daniela","Petra","Enrica", "Francisca","Hassam","Ximena"};
	int comisionArrayFixed[] = {100,200,300,400,500,600,700,800,900,1000,450,300,230,500,600,200,120,506,908,203};
	
	
	public EmpleadoModelo(Statement statement) {
		this.statement = statement;
	}
	
	
	public void agregarEmpleadoUsuario(String nombre, int comision) {
		try {
			String insertValue="INSERT IGNORE INTO Empleado (Nombre, Comision) VALUES(+'"+nombre+"',"+comision+")";
			statement.executeUpdate(insertValue);
		}catch(SQLException e) {
			e.printStackTrace();}
	}
	
	//Metodos para administrador
	//Agregar hilos para este proceso
	public void agregarEmpleadoAdministrador(int numeroAgregar) {
		intArray = new int[numeroAgregar];
		if (intArray.length<=nomArrayFixed.length) {
		for(int i=0; i< intArray.length;i++) {
			try {
				String insertValue = "INSERT IGNORE INTO Empleado VALUES("+intArray[i]+","+"'"+nomArrayFixed[i]+"'"+","+comisionArrayFixed[i]+")";
				statement.executeUpdate(insertValue);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}else{
			int contador = numeroAgregar/20;
			int cuantasVeces = contador *20;
			for(int i=0; i<contador;i++) {
				for(int j=0; j<20;j++) {
					try {
						String insertValue = "INSERT IGNORE INTO Empleado VALUES("+intArray[i]+","+"'"+nomArrayFixed[i]+"'"+","+comisionArrayFixed[i]+")";
						statement.executeUpdate(insertValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			int nuevoFor= numeroAgregar-cuantasVeces;
			for(int i=0; i<nuevoFor;i++) {
				try {
					String insertValue = "INSERT IGNORE INTO Empleado VALUES("+intArray[i]+","+"'"+nomArrayFixed[i]+"'"+","+comisionArrayFixed[i]+")";
					statement.executeUpdate(insertValue);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
		
	public void crearTablaEmpleadoAdministrador() {
		try {
			String crearTablaEmpleado= "CREATE TABLE IF NOT EXISTS Empleado(No_empleado INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Nombre VARCHAR(30) NOT NULL, "
					+ "Comision float NOT NULL)";
			statement.executeUpdate(crearTablaEmpleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarEmpleadoAdministrador(int noEmpleado) {
		
		try {
			String deleteValue="DELETE IGNORE FROM Empleado WHERE No_empleado="+noEmpleado;
			statement.executeUpdate(deleteValue);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarTablaEmpleadoAdministrador() {
		try {
			String eliminarEmpleado = "DROP TABLE IF EXISTS Empleado";
			statement.executeUpdate(eliminarEmpleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarEmpleadoAdministrador() {
		
		try {
			String eliminarEmpleado = "TRUNCATE TABLE Empleado";
			statement.executeUpdate(eliminarEmpleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificarDato(int no_empleado, String queModifica, String modificacion) {
		try {

				String modificar = "UPDATE Empleado SET "+queModifica+"= '"+modificacion+"'"+"WHERE No_empleado="+no_empleado;
				statement.executeUpdate(modificar);

		}catch(SQLException e) {
			e.printStackTrace();

		}
	}
}
