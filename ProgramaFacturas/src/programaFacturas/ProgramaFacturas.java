package programaFacturas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vistas.Reporte;
import vistas.VistaUno;

public class ProgramaFacturas extends JPanel{
	
	VistaUno panelSuperior, panelInferior, panelUltimo;
	JPanel mainPanel;
	
	public ClienteModelo clienteModelo;
	public ArticuloModelo articuloModelo;
	public EmpleadoModelo empleadoModelo;
	public FacturaModelo facturaModelo;
	public DetalleModelo detalleModelo;
	
	public ProgramaFacturas(ClienteModelo clienteModelo, ArticuloModelo articuloModelo, EmpleadoModelo empleadoModelo, FacturaModelo facturaModelo, DetalleModelo detalleModelo) {
		this.clienteModelo= clienteModelo;
		this.articuloModelo = articuloModelo;
		this.empleadoModelo = empleadoModelo;
		this.detalleModelo = detalleModelo;
		this.facturaModelo = facturaModelo;
		
		panelSuperior = new VistaUno(this,"Busqueda");
		panelInferior = new VistaUno();
		panelUltimo = new VistaUno(this,panelSuperior, panelInferior);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(panelSuperior);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(panelInferior);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(panelUltimo);
        mainPanel.add(Box.createGlue());
        
        
        
	}

	public static void main(String[] args) throws Exception{
		//1. Genere la base de datos
		//URL de la conexion a la base de datos con nombre de la base a generar, a continuacion usuario y contrase;a se dejan nulos
		int intArray[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		final String url="jdbc:mysql://localhost:3306/Facturas";
		final String user="root";
		final String password="";

		try {
			//En sistemas antiguos, para que DriverManager tuviera "registrados" los drivers, era necesario cargar la clase en la máquina virtual. 
			//Para eso es el Class.forName(), simplemente carga la clase con el nombre indicado. 
			//A partir de JDK 6, los drivers JDBC 4 ya se registran automáticamente y no es necesario el Class.forName(), sólo que estén en el classpath de la JVM.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Objetos para crear la conexion
			Connection conexion = DriverManager.getConnection(url,user,password);
			Statement statement = conexion.createStatement();
			
			

			
			
			//E-A-C-F-D
			EmpleadoModelo empleadoModelo = new EmpleadoModelo(statement);
			ArticuloModelo articuloModelo = new ArticuloModelo(statement);

			FacturaModelo facturaModelo = new FacturaModelo(statement);
			DetalleModelo detalleModelo = new DetalleModelo(statement);
			ClienteModelo clienteModelo = new ClienteModelo(statement);
			
			
			
	        //Create and set up the window.
	        JFrame frame = new JFrame("Programa facturas");
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        ProgramaFacturas programaFacturas = new ProgramaFacturas(clienteModelo, articuloModelo, empleadoModelo, facturaModelo, detalleModelo);
	        programaFacturas.mainPanel.setOpaque(true); 
	        frame.setContentPane(programaFacturas.mainPanel);
	        
	        

	        //Display the window.
	        frame.pack();
	        Reporte reporte = new Reporte(statement);
	        frame.setVisible(true);

	        //
		
		if(conexion !=null) {		
			System.out.println("Conexión exitosa a la base de datos MySQL");
			/*conexion.close();*/}
	
		}catch(ClassNotFoundException e) {
			System.out.println("Error: No se encontró el controlador JDBC");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Error: No se pudo establecer la conexión a la base de datos");
			e.printStackTrace();
		}
	}
}

