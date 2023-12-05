package programaFacturas;

import java.sql.*;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ClienteModelo {
	private Statement statement;
	private int intArray[];
	
    int clave;
    String nombre; 
    String direccion; 
    String mail; 
	
	//Para crear los registros 
	String nomArrayFixed [] = {"Juan","Jorge","Paco","Luis","Xanat","Pedro","Nino","Jose","Manuel","Vicente","Hugo","Richard","Pepe","JuanJo","Eduardo","Enrique","Elon","Martha","Sofia","Caritina"};
	String dirArrayFixed[] = {"Lagos de Moreno","Lagos de Michoacan","Laguna del volcan","Rio papagayo","Rio papaloapan","Laguna de colores","Laguna del nevado","Laguna de laredo","Rio Jimenez","Rio Suchiate","Lagos de Moreno","Lagos de Michoacan","Laguna del volcan","Rio papagayo","Rio papaloapan","Laguna de colores","Laguna del nevado","Laguna de laredo","Rio Jimenez","Rio Suchiate"};
	
	
	public ClienteModelo(Statement statement) {
		this.statement = statement;
	}
	
	
	
	//Metodos para administrador
	//Agregar hilos para este proceso
	//Agregar, eliminar, consultar y modificar
	
	public void agregarClienteUsuario(String nombre, String correo, String direccion) {
		try {
			//***********A CAMBIAR POR EL ACTUAL NUMERO DE VALORES EN LA BASE 
			
			//String insertValue="INSERT IGNORE INTO CLiente (Nombre, Direccion, Mail) VALUES("+nombre+","+direccion+","+correo+")";
			String insertValue="INSERT IGNORE INTO Cliente (Nombre, Direccion, Mail) VALUES(+'"+nombre+"','"+direccion+"','"+correo+"')";
			statement.executeUpdate(insertValue);
		}catch(SQLException e) {
			e.printStackTrace();}
	}
	
	public void agregarClienteAdministrador(int numeroAgregar) {
		intArray = new int[numeroAgregar];
		if (intArray.length<=nomArrayFixed.length) {
		for(int i=0; i< intArray.length;i++) {
			try {
				String correo = nomArrayFixed[i]+"_"+ intArray[i]+ "@hotmail.com";
				String insertValue = "INSERT IGNORE INTO Cliente VALUES("+intArray[i]+","+"'"+nomArrayFixed[i]+"'"+","+"'"+dirArrayFixed[i]+"'"+","+"'"+correo+"'"+")";
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
						String correo = nomArrayFixed[j]+"_"+ intArray[j]+ "@hotmail.com";
						String insertValue = "INSERT IGNORE INTO Cliente VALUES("+intArray[j]+","+"'"+nomArrayFixed[j]+"'"+","+"'"+dirArrayFixed[j]+"'"+","+"'"+correo+"'"+")";
						statement.executeUpdate(insertValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			int nuevoFor= numeroAgregar-cuantasVeces;
			for(int i=0; i<nuevoFor;i++) {
				try {
					String correo = nomArrayFixed[i]+"_"+ intArray[i]+ "@hotmail.com";
					String insertValue = "INSERT IGNORE INTO Cliente VALUES("+intArray[i]+","+"'"+nomArrayFixed[i]+"'"+","+"'"+dirArrayFixed[i]+"'"+","+"'"+correo+"'"+")";
					statement.executeUpdate(insertValue);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
		
	public void crearTablaClienteAdministrador() {
		try {
			String crearTablaCliente = "CREATE TABLE IF NOT EXISTS Cliente(Cve_cli INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Nombre VARCHAR(30) NOT NULL, "
			+ "Direccion VARCHAR(30) NOT NULL, Mail VARCHAR(30) NOT NULL)";
			statement.executeUpdate(crearTablaCliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarTablaClienteAdministrador() {
		try {
			String eliminarCliente = "DROP TABLE IF EXISTS Cliente";
			statement.executeUpdate(eliminarCliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarClienteAdministrador() {
		
		try {
			String eliminarCliente = "TRUNCATE TABLE Cliente";
			statement.executeUpdate(eliminarCliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarClienteAdministrador(int cveEliminar) {
		try {
			String deleteValue="DELETE IGNORE FROM Cliente WHERE Cve_cli="+cveEliminar;
			statement.executeUpdate(deleteValue);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void consultarClienteTodo(DefaultTableModel tabla1) {

        
		try {
			String obtenerCliente = "SELECT * FROM Cliente";
			ResultSet resultSet = statement.executeQuery(obtenerCliente);
			while(resultSet.next()) {
                 clave = resultSet.getInt("Cve_cli");
                 nombre = resultSet.getString("Nombre");
                 direccion = resultSet.getString("Direccion");
                 mail = resultSet.getString("Mail");
        		
                 tabla1.addRow(new Object[]{clave,nombre,direccion,mail});
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void consultaEspecifica() {
		
	}
	public void modificarDato(int Cve_cliente, String queModifica, String modificacion) {
		try {
		String modificar = "UPDATE Cliente SET "+queModifica+"= '"+modificacion+"'"+"WHERE Cve_cli="+Cve_cliente;
		statement.executeUpdate(modificar);
		}catch(SQLException e) {
			e.printStackTrace();

		}
	}
		
	
}


