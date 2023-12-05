package programaFacturas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBase {
	private EmpleadoModelo empleadoModelo;
	private ArticuloModelo articuloModelo;
	private ClienteModelo clienteModelo;
	private FacturaModelo facturaModelo;
	private DetalleModelo detalleModelo;
	
	//Se eliminan todos los registros existentes previamente en el orden necesario 
	
	public CrearBase(EmpleadoModelo empleadoModelo, ArticuloModelo articuloModelo, ClienteModelo clienteModelo, FacturaModelo facturaModelo, DetalleModelo detalleModelo) {
		this.articuloModelo = articuloModelo;
		this.empleadoModelo = empleadoModelo;
		this.clienteModelo = clienteModelo;
		this.facturaModelo = facturaModelo;
		this.detalleModelo= detalleModelo;
	}
	
	public void resetDataBase() {
		empleadoModelo.eliminarEmpleadoAdministrador();
		clienteModelo.eliminarClienteAdministrador();
		articuloModelo.eliminarArticuloAdministrador();
		detalleModelo.eliminarDetalleAdministrador();
		facturaModelo.eliminarFacturaAdministrador();

	}
	private void resetTables() {
		empleadoModelo.eliminarTablaEmpleadoAdministrador();
		clienteModelo.eliminarTablaClienteAdministrador();
		articuloModelo.eliminarTablaArticuloAdministrador();
		detalleModelo.eliminarTablaDetalleAdministrador();
		facturaModelo.eliminarTablaFacturaAdministrador();

	}
	private void generarTablas() {
		empleadoModelo.crearTablaEmpleadoAdministrador();
		clienteModelo.crearTablaClienteAdministrador();
		articuloModelo.crearTablaArticulosAdministrador();
		facturaModelo.crearTablaFacturasAdministrador();
		detalleModelo.crearTablaDetalleAdministrador();

	}
	
	private void genericoTablas() {
		clienteModelo.agregarClienteAdministrador(25);
		empleadoModelo.agregarEmpleadoAdministrador(25);
		articuloModelo.agregarArticuloAdministrador(25);
		facturaModelo.agregarFacturaAdministrador(25);
		detalleModelo.agregarDetalleAdministrador(25);
	}
	
	public void generarBaseDeCero() {
		this.resetDataBase();
		this.resetTables();
		this.generarTablas();
		this.genericoTablas();
	}
	
	public void crearTablas() {
		this.genericoTablas();
	}
}