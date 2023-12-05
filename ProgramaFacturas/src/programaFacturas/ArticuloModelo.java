package programaFacturas;

import java.sql.SQLException;
import java.sql.Statement;

public class ArticuloModelo {
	private Statement statement;
	private int intArray[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	
	//Para crear los registros 
	String descArtFixed [] = {"Bolsa de tornillos JIS","Clavos doble cara","Bolsa de metales","Piedras preciosas para const","Tierras raras con metal","Capacitor gigante","Resistencia gigante","Motor corriente alterna","Tuerca","Martillo", "Protector de vista", "Paquete de guantes","Patas de goma", "Tuerca rusa", "Gato hidraulico","Desarmador de cruz","Desarmador estrella apple", "Paquete de desarmadores","Desarmador electrico","Placa de metal"};
	int costoArrayFixed[]= {520,520,515,802,1820,1328,1330,1796,999,27,300,425,670,548,390,670,333,890,902,1003};
	int cuantosArrayFixed[]= {100,200,300,400,500,100,200,300,400,500,600,700,800,900,800,700,600,500,400,300};

	
	
	public ArticuloModelo(Statement statement) {
		this.statement = statement;
	}
	
	
	public void agregarArticuloModelo(String descripcion, int costoArt, int cantidad) {
		try {
			String insertValue="INSERT IGNORE INTO Articulo (Descripcion, Costo, Cantidad) VALUES('"+descripcion+"'"+","+costoArt+","+cantidad+")";
			statement.executeUpdate(insertValue);
		}catch(SQLException e) {
			e.printStackTrace();}
	}
	
	
	//Metodos para administrador
	//Agregar hilos para este proceso
	public void agregarArticuloAdministrador(int numeroAgregar) {
		intArray = new int[numeroAgregar];
		if (intArray.length<=descArtFixed.length) {
		for(int i=0; i< intArray.length;i++) {
			try {
				String insertValue = "INSERT IGNORE INTO Articulo (Descripcion,Costo,Cantidad) VALUES('"+descArtFixed[i]+"'"+","+costoArrayFixed[i]+","+cuantosArrayFixed[i]+")";
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
						String insertValue = "INSERT IGNORE INTO Articulo (Descripcion,Costo,Cantidad) VALUES('"+descArtFixed[i]+"'"+","+costoArrayFixed[i]+","+cuantosArrayFixed[i]+")";
						statement.executeUpdate(insertValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			int nuevoFor= numeroAgregar-cuantasVeces;
			for(int i=0; i<nuevoFor;i++) {
				try {
					String insertValue = "INSERT IGNORE INTO Articulo (Descripcion,Costo,Cantidad) VALUES('"+descArtFixed[i]+"'"+","+costoArrayFixed[i]+","+cuantosArrayFixed[i]+")";
					statement.executeUpdate(insertValue);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
	}
		
	public void crearTablaArticulosAdministrador() {
		try {
			String crearTablaArticulo="CREATE TABLE IF NOT EXISTS Articulo(Cve_articulo INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Descripcion VARCHAR(30), Costo INT NOT NULL, Cantidad INT NOT NULL)";	
			statement.executeUpdate(crearTablaArticulo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminarArticuloAdministrador(int cve_Articulo) {
		try {
			String deleteValue="DELETE IGNORE FROM Articulo WHERE Cve_articulo="+cve_Articulo;
			statement.executeUpdate(deleteValue);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarTablaArticuloAdministrador() {
		try {
			String eliminarFactura = "DROP TABLE IF EXISTS Articulo";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarArticuloAdministrador() {
		
		try {
			String eliminarFactura = "TRUNCATE TABLE Articulo";
			statement.executeUpdate(eliminarFactura);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarDato(int Cve_articulo, String queModifica, String modificacion) {
		try {
		String modificar = "UPDATE Articulo SET "+queModifica+"= '"+modificacion+"'"+"WHERE Cve_articulo="+Cve_articulo;
		statement.executeUpdate(modificar);
		}catch(SQLException e) {
			e.printStackTrace();

		}
	}

}
