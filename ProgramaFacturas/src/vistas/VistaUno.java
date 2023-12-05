package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import programaFacturas.ClienteModelo;
import programaFacturas.ProgramaFacturas;


public class VistaUno extends JPanel implements ActionListener,ComponentListener,ItemListener{
	private ProgramaFacturas programaFacturas; //Este es nuestro posible controlador
	private String myTitle;
    public JTextField textField2 = new JTextField(10);
    JTextField textField1 = new JTextField(10);


     private BoxOpciones opciones = new BoxOpciones(this);

     JComboBox<String> comboBox2 = opciones.getSubComboBox();
     JComboBox<String> comboBox1 = opciones.getMainComboBox();
     
	public VistaUno(ProgramaFacturas programaFacturas/*Controlador*/, String myTitle) {
		this.programaFacturas = programaFacturas;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(myTitle),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        this.myTitle = myTitle;
        
  
        // Crear un JLabel y un JTextField
        JLabel label1 = new JLabel("Clave");
 // 10 es el ancho del JTextField

        // Establecer posiciones específicas

        JPanel unitGroup = new JPanel() {
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }
            public Dimension getPreferredSize() {
                return new Dimension(150,
                                     super.getPreferredSize().height);
            }
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        unitGroup.setLayout(new BoxLayout(unitGroup,
                BoxLayout.PAGE_AXIS));
        unitGroup.setBorder(BorderFactory.createEmptyBorder(
                0,0,0,5));
        unitGroup.add(comboBox1);
        
        JPanel chooserPanel = new JPanel();
        chooserPanel.setLayout(new BoxLayout(chooserPanel,
                                             BoxLayout.PAGE_AXIS));
        JPanel cveName = new JPanel();
        cveName.setLayout(new BoxLayout(cveName, BoxLayout.PAGE_AXIS));
        
        JPanel cvePanel = new JPanel();
        cvePanel.setLayout(new BoxLayout(cvePanel, BoxLayout.PAGE_AXIS));
        
        cveName.add(label1);
        cvePanel.add(textField1);
        chooserPanel.add(comboBox2);
        add(unitGroup);
        add(chooserPanel);
        add(cveName);
        add(cvePanel);
        unitGroup.setAlignmentY(TOP_ALIGNMENT);
        chooserPanel.setAlignmentY(TOP_ALIGNMENT);
        cveName.setAlignmentY(TOP_ALIGNMENT);
        cvePanel.setAlignmentY(TOP_ALIGNMENT);
	
	}
	
	public VistaUno() {
 // 10 es el ancho del JTextField
        JLabel modificar = new JLabel("Input: ");
        
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input para modificar"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        JPanel unitGroup = new JPanel() {
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }
            public Dimension getPreferredSize() {
                return new Dimension(150,
                                     super.getPreferredSize().height);
            }
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        unitGroup.setLayout(new BoxLayout(unitGroup,
                BoxLayout.PAGE_AXIS));
        unitGroup.setBorder(BorderFactory.createEmptyBorder(
                0,0,0,5));
        unitGroup.add(modificar);
        
        JPanel cuadro = new JPanel();
        cuadro.setLayout(new BoxLayout(cuadro, BoxLayout.PAGE_AXIS));
        cuadro.add(textField2);
        add(unitGroup);
        add(cuadro);
        unitGroup.setAlignmentY(TOP_ALIGNMENT);
        cuadro.setAlignmentY(TOP_ALIGNMENT);

	}
	
	public VistaUno(ProgramaFacturas b, VistaUno a, VistaUno input) {
        JButton agregarButton = new JButton("Agregar");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");
        

        // Agregar ActionListener a los botones
        agregarButton.addActionListener(new ActionListener() {
        	  @Override
        	    public void actionPerformed(ActionEvent e) {
        	        // Obtener el valor seleccionado en comboBox1
        	        String selectedTable = (String) a.comboBox1.getSelectedItem();

        	        // Lógica para el botón "Agregar" según el valor seleccionado en comboBox1
        	        switch (selectedTable) {
        	            case "Selecciona tabla":
        	                JOptionPane.showMessageDialog(null, "Selecciona una tabla antes de agregar");
        	                break;
        	            case "Cliente":
        	                // Lógica para agregar un cliente
        	                System.out.println("Cliente");
        	                SubVista vistaCliente = new SubVista(b.clienteModelo);       
        	                break;
        	            case "Empleado":
        	                System.out.println("Empleado");
        	                SubVista vistaEmpleado = new SubVista(b.empleadoModelo);   
        	                // Lógica para agregar un empleado
        	                // (Agrega la lógica según tus necesidades)
        	                break;
        	            case "Articulo":
        	                System.out.println("Articulo");
        	                SubVista vistaArticulo = new SubVista(b.articuloModelo);   
        	                // Lógica para agregar un artículo
        	                // (Agrega la lógica según tus necesidades)
        	                break;
        	            case "Factura":
        	                System.out.println("Factura");
        	                VistaFactura vistaFactura = new VistaFactura(b.facturaModelo);
        	                VistaFactura vistaDetalle = new VistaFactura(b.detalleModelo/*, vistaFactura*/);
        	                JPanel mainPanel = new JPanel();
        	                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        	                mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        	                mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        	                mainPanel.add(vistaFactura);
        	                mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        	                mainPanel.add(vistaDetalle);
        	                mainPanel.setOpaque(true); 
        	                
        	    	        JFrame frame = new JFrame("Factura");
        	    	        frame.setContentPane(mainPanel);
        	    	        
        	    	        frame.pack();
        	    	        frame.setVisible(true);

        	                // Lógica para agregar una factura
        	                // (Agrega la lógica según tus necesidades)
        	                break;
            }
        	  }});

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón "Modificar"
    	        // Obtener el valor seleccionado en comboBox1
    	        String selectedTable = (String) a.comboBox1.getSelectedItem();
    	        String selectedColumn = (String) a.comboBox2.getSelectedItem();
    	        
    	        // Lógica para el botón "Agregar" según el valor seleccionado en comboBox1
    	        switch (selectedTable) {
    	            case "Selecciona tabla":
    	                JOptionPane.showMessageDialog(null, "Selecciona una tabla antes de agregar");
    	                break;
    	            case "Cliente":
    	            	switch(selectedColumn) {
    	            	case "Columna":
        	                JOptionPane.showMessageDialog(null, "Selecciona una columna");
        	                break;
    	            	default:
    	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	            		b.clienteModelo.modificarDato(clave, selectedColumn, input.textField2.getText());
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	            		break;
    	            	}
    	                break;
    	            case "Empleado":
    	            	switch(selectedColumn) {
    	            	case "Columna":
        	                JOptionPane.showMessageDialog(null, "Selecciona una columna");
        	                break;
    	            	default:
    	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	            		b.empleadoModelo.modificarDato(clave, selectedColumn, input.textField2.getText());
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	            		break;
    	            	}
    	                break;
    	            case "Articulo":
    	            	switch(selectedColumn) {
    	            	case "Columna":
        	                JOptionPane.showMessageDialog(null, "Selecciona una columna");
        	                break;
    	            	default:
    	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	            		b.articuloModelo.modificarDato(clave, selectedColumn, input.textField2.getText());
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	            		break;
    	            	}
    	                break;
    	                
    	            case "Factura":
    	                System.out.println("Factura");
    	            	switch(selectedColumn) {
    	            	case "Columna":
        	                JOptionPane.showMessageDialog(null, "Selecciona una columna");
        	                break;
    	            	default:
    	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	            		b.facturaModelo.modificarDato(clave, selectedColumn, input.textField2.getText());
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	            		break;
    	            	}
 
    	                break;
        }
                
                
            }

			
			
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 // Lógica para el botón "Modificar"
    	        // Obtener el valor seleccionado en comboBox1
    	        String selectedTable = (String) a.comboBox1.getSelectedItem();
    	        
    	        // Lógica para el botón "Agregar" según el valor seleccionado en comboBox1
    	        switch (selectedTable) {
    	            case "Selecciona tabla":
    	                JOptionPane.showMessageDialog(null, "Selecciona una tabla antes de agregar");
    	                break;
    	            case "Cliente":
	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	                    b.clienteModelo.eliminarClienteAdministrador(clave);
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	            		break;
    	            case "Empleado":
	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	                    b.empleadoModelo.eliminarEmpleadoAdministrador(clave);
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	                break;
    	            case "Articulo":
	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	                    b.articuloModelo.eliminarArticuloAdministrador(clave);
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	                break;
    	                
    	            case "Factura":
    	                System.out.println("Factura");
	            		try {
    	                    int clave = Integer.parseInt(a.textField1.getText());
    	                    b.facturaModelo.eliminarFacturaAdministrador(clave);
        	                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
    	            		}catch(Exception e1) {
    	    	                JOptionPane.showMessageDialog(null, "Corrige input");
    	            		}
    	                break;
        }
                
            }
        });
        
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Acciones"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        JPanel unitGroup = new JPanel() {
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }
            public Dimension getPreferredSize() {
                return new Dimension(150,
                                     super.getPreferredSize().height);
            }
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        
        unitGroup.setLayout(new BoxLayout(unitGroup,
                BoxLayout.PAGE_AXIS));
        unitGroup.setBorder(BorderFactory.createEmptyBorder(
                0,0,0,5));
        unitGroup.add(modificarButton);
        
        JPanel modificarPanel = new JPanel();
        modificarPanel.setLayout(new BoxLayout(modificarPanel,
                                             BoxLayout.PAGE_AXIS));
        JPanel eliminarPanel = new JPanel();
        eliminarPanel.setLayout(new BoxLayout(eliminarPanel, BoxLayout.PAGE_AXIS));
        
        modificarPanel.add(agregarButton);
        eliminarPanel.add(eliminarButton);
        add(unitGroup);
        add(modificarPanel);
        add(eliminarPanel);
        unitGroup.setAlignmentY(TOP_ALIGNMENT);
        modificarPanel.setAlignmentY(TOP_ALIGNMENT);
        eliminarPanel.setAlignmentY(TOP_ALIGNMENT);
        
	}
	
    public Dimension getMaximumSize() {
        return new Dimension(Integer.MAX_VALUE,
                             getPreferredSize().height);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}