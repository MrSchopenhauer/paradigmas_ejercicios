package programaFacturas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import vistas.Reporte;

public class ModeloBusquedas {
	private Connection connection;
	private Reporte reporte;
	private String sql;
	
	public String getSql() {
		return sql;
	}

	public ModeloBusquedas (Connection connection) {
		this.connection = connection;
	}
	public ModeloBusquedas () {
	}
	
	public String opcionesEnteros(String selectedTable, String selectedParameter, String searchTerm) {
    	switch(selectedParameter) {
    	case "Cve_cli":
			// Fetch data based on the selected parameter and search term
			sql = "SELECT * FROM " + selectedTable + " WHERE Cve_cli = "+searchTerm+"";
			break;
    	case "No_empleado":
    		// Fetch data based on the selected parameter and search term
			sql = "SELECT * FROM " + selectedTable + " WHERE No_empleado = "+searchTerm+"";
    		break;
    	case "Comision":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Comision = "+searchTerm+"";
    		break;
    	case "Cve_articulo":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Cve_articulo = "+searchTerm+"";
    		break;
    	case "Costo":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Costo = "+searchTerm+"";
    		break;
    	case "Cantidad":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Cantidad= "+searchTerm+"";
    		break;
    	case "No_factura":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE No_factura= "+searchTerm+"";
    		break;
    	case "Cantidad_vendida":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Cantidad_vendida= "+searchTerm+"";
    		break;
    	case "Total":
    		// Fetch data based on the selected parameter and search term
    		sql = "SELECT * FROM " + selectedTable + " WHERE Total= "+searchTerm+"";
    		break;
    		default:
    			sql =null;
               	break;
    	}
    	return sql;
	}
	
	public String opcionesCadenas(String selectedTable, String selectedParameter, String searchTerm) {
	    String sql = "SELECT * FROM " + selectedTable + " WHERE " + selectedParameter + " LIKE ?";
	    searchTerm = "%" + searchTerm + "%";
	    return sql;
	}

	
	

	

    


}
