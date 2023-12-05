package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import programaFacturas.ArticuloModelo;
import programaFacturas.ClienteModelo;
import programaFacturas.EmpleadoModelo;


public class SubVista extends JFrame implements ActionListener{
	//Labels
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	//Textos
	private JTextField texto1;
	private JTextField texto2;
	private JTextField texto3;
	private JButton boton;
	//Modelos
	private ClienteModelo paraCliente;
	private EmpleadoModelo paraEmpleado;
	private ArticuloModelo paraArticulo;

	//***********Cliente
	public SubVista(ClienteModelo clienteModelo) {
		super("SubVista");
		this.paraCliente = clienteModelo;
		this.setSize(600,100);
		this.vistaCliente();
		this.setVisible(true);
	}
	
	public void vistaCliente() {

		label1 = new JLabel("Nombre:");
		label2 = new JLabel("Direccion:");
		label3 = new JLabel("Correo:");
		
		texto1 = new JTextField(20);
		texto2 = new JTextField(20);
		texto3 = new JTextField(20);
		
		boton = new JButton("Agregar");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		this.add(panel);
		
		panel.add(label1);
		panel.add(texto1);
		panel.add(label2);
		panel.add(texto2);
		panel.add(label3);
		panel.add(texto3);
		panel.add(boton);
		
		boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearRegistroCliente();
            	
            }

		});
	}
	
	public void crearRegistroCliente() {
		String nombre = texto1.getText();
		String correo = texto2.getText();
		String direccion = texto3.getText();
		try {
		paraCliente.agregarClienteUsuario(nombre, correo, direccion);
        JOptionPane.showMessageDialog(null, "Operacion exitosa");
		}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Corrige el input");
		}
	}
	
	//***********Empleado
	public SubVista(EmpleadoModelo empleadoModelo) {
		super("SubVista");
		this.paraEmpleado = empleadoModelo;
		this.setSize(600,100);
		this.vistaEmpleado();
		this.setVisible(true);
	}

    public void vistaEmpleado() {
        label1 = new JLabel("Nombre:");
        label2 = new JLabel("Comision");

        texto1 = new JTextField(20);
        texto2 =  new JTextField(20); // Utiliza un JFormattedTextField para números enteros

        boton = new JButton("Agregar");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        this.add(panel);

        panel.add(label1);
        panel.add(texto1);
        panel.add(label2);
        panel.add(texto2);
        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearRegistroEmpleado();
            }
        });
    }
	
    public void crearRegistroEmpleado() {
        String nombre = texto1.getText();
        int comision = Integer.parseInt(texto2.getText()); // Obtén el valor como entero

        try {
            paraEmpleado.agregarEmpleadoUsuario(nombre, comision);
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corrige el input");
        }
    }

    //***********Articulo
	public SubVista(ArticuloModelo articuloModelo) {
		super("SubVista");
		this.paraArticulo = articuloModelo;
		this.setSize(600,100);
		this.vistaArticulo();
		this.setVisible(true);
	}
	
	public void vistaArticulo() {

		label1 = new JLabel("Descripcion:");
		label2 = new JLabel("Costo:");
		label3 = new JLabel("Cantidad:");
		
		texto1 = new JTextField(20);
		texto2 = new JTextField(20);
		texto3 = new JTextField(20);
		
		boton = new JButton("Agregar");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		this.add(panel);
		
		panel.add(label1);
		panel.add(texto1);
		panel.add(label2);
		panel.add(texto2);
		panel.add(label3);
		panel.add(texto3);
		panel.add(boton);
		
		boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearRegistroArticulo();
            	
            }

		});
	}
	
    public void crearRegistroArticulo() {
        String nombre = texto1.getText();
        int costo = Integer.parseInt(texto2.getText()); // Obtén el valor como entero
        int cantidad = Integer.parseInt(texto3.getText()); 
        
        try {
            paraArticulo.agregarArticuloModelo(nombre, costo, cantidad);
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corrige el input");
        }
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
