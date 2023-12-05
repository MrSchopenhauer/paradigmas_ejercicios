package programaFacturas;

import java.sql.SQLException;
import java.sql.Statement;

public class DetalleModelo {
	//Agregar, eliminar, modificar y consultar 
	//Es en detalle en donde se permite tener mas articulos 
	//A la hora de generar considerar multiplicaciones
	public int numFacturaArrayFixed[]= {104,208,309,401,546,664,798,898,999,1006,1103,1202,1303,14402,1520,1610,1740,1198,1949,2000};
	private Statement statement;
	//private FacturaModelo modeloFactura;
	//cve_articulo
	private int intArrayDoble[]= {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
	//cantidad vendida
	private int porCuanto[]= {2,4,6,5,3,5,6,5,10,4,3,2,4,1,5,6,4,8,2,1};
	//private int numFactura[] = modeloFactura.numFacturaArrayFixed;//Esto es provisional solo para crear la primera base
	
	//Para crear los registros 
	
	public DetalleModelo(Statement statement /*,FacturaModelo modeloFactura*/) {
		this.statement = statement;
		//this.modeloFactura = modeloFactura;
	}
	
	
	public void agregarDetalleModelo(int numFactura, int costoArt, int cantidad) {
		try {
			String insertValue = "INSERT IGNORE INTO Detalle VALUES("+numFactura+","+costoArt+","+cantidad+")";
			statement.executeUpdate(insertValue);
		}catch(SQLException e) {
			e.printStackTrace();}
	}
	
	
	//Metodos para administrador
	//Agregar hilos para este proceso
	public void agregarDetalleAdministrador(int numeroAgregar) {
		int intArray []= new int[numeroAgregar];
		if (intArray.length<=numFacturaArrayFixed.length) {
		for(int i=0; i< intArray.length;i++) {
			try {
				String insertValue = "INSERT IGNORE INTO Detalle(No_factura, Cve_articulo, Cantidad_vendida) VALUES("+numFacturaArrayFixed[i]+","+intArrayDoble[i]+","+porCuanto[i]+")";
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
						String insertValue = "INSERT IGNORE INTO Detalle(No_factura, Cve_articulo, Cantidad_vendida) VALUES("+numFacturaArrayFixed[i]+","+intArrayDoble[i]+","+porCuanto[i]+")";
						statement.executeUpdate(insertValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			int nuevoFor= numeroAgregar-cuantasVeces;
			for(int i=0; i<nuevoFor;i++) {
				try {
					String insertValue = "INSERT IGNORE INTO Detalle(No_factura, Cve_articulo, Cantidad_vendida) VALUES("+numFacturaArrayFixed[i]+","+intArrayDoble[i]+","+porCuanto[i]+")";
					statement.executeUpdate(insertValue);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
		
	public void crearTablaDetalleAdministrador() {
		try {
			String crearTablaDetalle= "CREATE TABLE IF NOT EXISTS Detalle(No_factura INT , FOREIGN KEY(No_factura) REFERENCES Factura(No_factura), Cve_articulo INT, FOREIGN KEY(Cve_articulo) REFERENCES Articulo(Cve_articulo), "
					+ "Cantidad_vendida INT NOT NULL)";
			statement.executeUpdate(crearTablaDetalle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarDetalleAdministrador(int no_Factura) {
		try {
			String deleteValue="DELETE IGNORE FROM Detalle WHERE No_factura="+no_Factura;
			statement.executeUpdate(deleteValue);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarTablaDetalleAdministrador() {
		try {
			String eliminarFactura = "DROP TABLE IF EXISTS Detalle";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarDetalleAdministrador() {
		
		try {
			String eliminarFactura = "TRUNCATE TABLE Detalle";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
