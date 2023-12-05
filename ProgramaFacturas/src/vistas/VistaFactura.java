package vistas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import programaFacturas.DetalleModelo;
import programaFacturas.FacturaModelo;

public class VistaFactura extends JPanel implements ActionListener {
	
	private String myTitle;
	//Factura_encabezado
    JLabel label1 = new JLabel("No_factura");
    JLabel label2 = new JLabel("Fecha aaaa-mm-dd");
    JLabel label3 = new JLabel("Total");
    JLabel label4 = new JLabel("Cve_cli");
    JLabel label5 = new JLabel("No_empleado");
    JTextField textField1 = new JTextField(10); // 10 es el ancho del JTextField
    JTextField textField3 = new JTextField(10);
    JTextField textField4 = new JTextField(10);
    JTextField textField5 = new JTextField(10);
	JButton boton = new JButton("Agregar");
	
	//Factura_detalle
    JLabel label11 = new JLabel("No_factura");
    JLabel label22 = new JLabel("Cve_articulo");
    JLabel label33 = new JLabel("Cantidad vendida");
    
    JTextField textField11 = new JTextField(10); // 10 es el ancho del JTextField
    JTextField textField22 = new JTextField(10);
    JTextField textField33 = new JTextField(10);
	JButton boton2 = new JButton("Agregar");

	
	private FacturaModelo paraFactura;
	private DetalleModelo paraDetalle;
	
	public VistaFactura(FacturaModelo paraFactura) {
		this.paraFactura = paraFactura;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Encabezado"),
                BorderFactory.createEmptyBorder(5,5,5,5)));

        
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
        
        JPanel text1 = new JPanel();
        text1.setLayout(new BoxLayout(text1,
                                             BoxLayout.PAGE_AXIS));
        unitGroup.setLayout(new BoxLayout(unitGroup,
                BoxLayout.PAGE_AXIS));
        unitGroup.setBorder(BorderFactory.createEmptyBorder(
                0,0,0,5));
        unitGroup.add(label1);
        

        JPanel text3 = new JPanel();
        text3.setLayout(new BoxLayout(text3,
                                             BoxLayout.PAGE_AXIS));

        
        JPanel text4 = new JPanel();
        text4.setLayout(new BoxLayout(text4,
                                             BoxLayout.PAGE_AXIS));
        
        JPanel total = new JPanel();
        total.setLayout(new BoxLayout(total, BoxLayout.PAGE_AXIS));
        
        JPanel text5 = new JPanel();
        text5.setLayout(new BoxLayout(text5,
                                             BoxLayout.PAGE_AXIS));
        JPanel cve_cliente = new JPanel();
        cve_cliente.setLayout(new BoxLayout(cve_cliente, BoxLayout.PAGE_AXIS));
        
        JPanel no_empleado = new JPanel();
        no_empleado.setLayout(new BoxLayout(no_empleado, BoxLayout.PAGE_AXIS));
        
        text1.add(textField1);

        total.add(label3);
        text3.add(textField3);
        cve_cliente.add(label4);
        text4.add(textField4);
        no_empleado.add(label5);
        text5.add(textField5);
        
        add(unitGroup);
        add(text1);

        add(total);
        add(text3);
        add(cve_cliente);
        add(text4);
        add(no_empleado);
        add(text5);
        add(boton);
        unitGroup.setAlignmentY(TOP_ALIGNMENT);
        text1.setAlignmentY(TOP_ALIGNMENT);
        total.setAlignmentY(TOP_ALIGNMENT);
        text3.setAlignmentY(TOP_ALIGNMENT);
        cve_cliente.setAlignmentY(TOP_ALIGNMENT);
        text4.setAlignmentY(TOP_ALIGNMENT);
        no_empleado.setAlignmentY(TOP_ALIGNMENT);
        text5.setAlignmentY(TOP_ALIGNMENT);
        boton.setAlignmentY(TOP_ALIGNMENT);
        
		boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearRegistroFacturaEncabezado();
            	
            }

		});
	}
	
    public void crearRegistroFacturaEncabezado() {
    	int no_factura = Integer.parseInt(textField1.getText()); 
        int total = Integer.parseInt(textField3.getText()); 
        int cve_cli = Integer.parseInt(textField4.getText());
        int no_empleado = Integer.parseInt(textField5.getText());
        
        try {
            paraFactura.agregarFacturaModelo(no_factura, total, cve_cli, no_empleado);
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corrige el input");
        }
    }
	
	public VistaFactura(DetalleModelo detalleModelo) {
		this.paraDetalle = detalleModelo;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Detalle"),
                BorderFactory.createEmptyBorder(5,5,5,5)));

        
        // Establecer posiciones específicas

        JPanel unitGroup2 = new JPanel() {
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
        
        JPanel text11 = new JPanel();
        text11.setLayout(new BoxLayout(text11,
                                             BoxLayout.PAGE_AXIS));
        unitGroup2.setLayout(new BoxLayout(unitGroup2,
                BoxLayout.PAGE_AXIS));
        unitGroup2.setBorder(BorderFactory.createEmptyBorder(
                0,0,0,5));
        unitGroup2.add(label11);
        
        JPanel text22 = new JPanel();
        text22.setLayout(new BoxLayout(text22,
                                             BoxLayout.PAGE_AXIS));

        JPanel text33 = new JPanel();
        text33.setLayout(new BoxLayout(text33,
                                             BoxLayout.PAGE_AXIS));
        JPanel cve_articulo = new JPanel();
        cve_articulo.setLayout(new BoxLayout(cve_articulo, BoxLayout.PAGE_AXIS));
        
        JPanel cantidad_vendida = new JPanel();
        cantidad_vendida.setLayout(new BoxLayout(cantidad_vendida, BoxLayout.PAGE_AXIS));
        
        
       
        
        /////////para hacer datos   
        
        text11.add(textField11);
        cve_articulo.add(label22);
        text22.add(textField22);
        cantidad_vendida.add(label33);
        text33.add(textField33);

        
        add(unitGroup2);
        add(text11);
        add(cve_articulo);
        add(text22);
        add(cantidad_vendida);
        add(text33);
        add(boton2);
        unitGroup2.setAlignmentY(TOP_ALIGNMENT);
        text11.setAlignmentY(TOP_ALIGNMENT);
        cve_articulo.setAlignmentY(TOP_ALIGNMENT);
        text22.setAlignmentY(TOP_ALIGNMENT);
        cantidad_vendida.setAlignmentY(TOP_ALIGNMENT);
        text33.setAlignmentY(TOP_ALIGNMENT);
        boton2.setAlignmentY(TOP_ALIGNMENT);
        
		boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearRegistroFacturaDetalle();
            	
            }

		});
	}
	
    public void crearRegistroFacturaDetalle() {
    	int no_factura = Integer.parseInt(textField11.getText()); 
        int cve_articulo = Integer.parseInt(textField22.getText()); 
        int cantidad_vendida = Integer.parseInt(textField33.getText());
        
        try {
            paraDetalle.agregarDetalleModelo(no_factura, cve_articulo, cantidad_vendida);
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corrige el input");
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
