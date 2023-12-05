package programaFacturas;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FacturaModelo {
	private Statement statement;
	
	//Para crear los registros 
	public int numFacturaArrayFixed[]= {104,208,309,401,546,664,798,898,999,1006,1103,1202,1303,14402,1520,1610,1740,1198,1949,2000};
	public int totalFacturaArrayFixed[]= {1040,2080,3090,4010,5460,6640,7980,8980,9990,108, 1560,1040,2060,802,9100,7968,5320,14368,1998,27};
	public int cve_clienteFixed[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,6,7,8,9,10};
	public int cve_empleadoFixed[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,4,5,16,7,18,19,20};
	public int intArray[];

	
	
	public FacturaModelo(Statement statement) {
		this.statement = statement;
	}
	
	
	public void agregarFacturaModelo(int numFactura, int totalFactura, int cve_cliente, int cve_empleador) {
		try {
			String insertValue="INSERT IGNORE INTO Factura (No_factura, Fecha, Total, Cve_cli, No_empleado) VALUES("+numFactura+","+"'"+java.time.LocalDate.now()+"'"+","+totalFactura+","+cve_cliente+","+cve_empleador+")";
			statement.executeUpdate(insertValue);
		}catch(SQLException e) {
			e.printStackTrace();}
	}
	
	
	//Metodos para administrador
	//Agregar hilos para este proceso
	public void agregarFacturaAdministrador(int numeroAgregar) {
		intArray = new int[numeroAgregar];
		if (intArray.length<=numFacturaArrayFixed.length) {
		for(int i=0; i< intArray.length;i++) {
			try {
				String insertValue = "INSERT IGNORE INTO Factura VALUES("+numFacturaArrayFixed[i]+","+"'"+java.time.LocalDate.now()+"',"+totalFacturaArrayFixed[i]+","+cve_clienteFixed[i]+","+cve_empleadoFixed[i]+")";
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
						String insertValue = "INSERT IGNORE INTO Factura VALUES("+intArray[i]+","+"'"+java.time.LocalDate.now()+"',"+totalFacturaArrayFixed[i]+","+cve_clienteFixed[i]+","+cve_empleadoFixed[i]+")";
						statement.executeUpdate(insertValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			int nuevoFor= numeroAgregar-cuantasVeces;
			for(int i=0; i<nuevoFor;i++) {
				try {
					String insertValue = "INSERT IGNORE INTO Factura VALUES("+intArray[i]+","+"'"+java.time.LocalDate.now()+"',"+totalFacturaArrayFixed[i]+","+cve_clienteFixed[i]+","+cve_empleadoFixed[i]+")";
					statement.executeUpdate(insertValue);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
		
	public void crearTablaFacturasAdministrador() {
		try {
			String crearTablaFactura= "CREATE TABLE IF NOT EXISTS Factura(No_factura INT NOT NULL PRIMARY KEY, Fecha DATE NOT NULL, "
					+ "Total INT NOT NULL, Cve_cli INT , FOREIGN KEY (Cve_cli) REFERENCES Cliente(Cve_cli), No_empleado INT , FOREIGN KEY(No_empleado) REFERENCES Empleado(No_empleado))";
			statement.executeUpdate(crearTablaFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarFacturaAdministrador(int noFactura) {
		try {
			String deleteValueDetalle = "DELETE IGNORE FROM Detalle WHERE No_factura="+noFactura;
			statement.executeUpdate(deleteValueDetalle);
			String deleteValue="DELETE IGNORE FROM Factura WHERE No_factura="+noFactura;
			statement.executeUpdate(deleteValue);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarTablaFacturaAdministrador() {
		try {
			String eliminarFactura = "DROP TABLE IF EXISTS Factura";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarFacturaAdministrador() {
		
		try {
			String eliminarFactura = "TRUNCATE TABLE Factura";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificarDato(int no_Factura, String queModifica, String modificacion) {
		try {
		String modificar = "UPDATE Factura SET "+queModifica+"= '"+modificacion+"'"+"WHERE No_factura="+no_Factura;
		statement.executeUpdate(modificar);
		}catch(SQLException e) {
			e.printStackTrace();

		}
	}
}
