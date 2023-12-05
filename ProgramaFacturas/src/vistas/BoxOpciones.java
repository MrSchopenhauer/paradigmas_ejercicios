package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class BoxOpciones extends JFrame implements ActionListener, ItemListener{
	
    protected JComboBox mainComboBox;
    protected JComboBox subComboBox;
    private Hashtable<Object, Object> subItems = new Hashtable<Object, Object>();
    private static final long serialVersionUID = 1L;
    
    
    public BoxOpciones(VistaUno vistaInyectada) {

        String[] items = {"Selecciona tabla", "Cliente", "Empleado", "Articulo", "Factura"};
        mainComboBox = new JComboBox(items);
        mainComboBox.addActionListener(this);
        mainComboBox.addItemListener(this);
        //prevent action events from being fired when the up/down arrow keys are used
        //mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        //  Create sub combo box with multiple models
        subComboBox = new JComboBox();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        subComboBox.addItemListener(this);
        getContentPane().add(subComboBox, BorderLayout.EAST);
        String[] subItems1 = {"Columna", "Nombre", "Direccion", "Mail"};
        subItems.put(items[1], subItems1);
        String[] subItems2 = {"Columna","Nombre", "Comision"};
        subItems.put(items[2], subItems2);
        String[] subItems3 = {"Columna", "Descripcion", "Costo", "Cantidad"};
        subItems.put(items[3], subItems3);
        String[] subItems4 = {"Columna", "Fecha", "Total", "Cve_cli","No_empleado"};
        subItems.put(items[4], subItems4);
//      mainComboBox.setSelectedIndex(1);
    }
    
    public BoxOpciones() {

        String[] items = {"Tabla", "Cliente", "Empleado", "Articulo", "Factura"};
        mainComboBox = new JComboBox(items);
        mainComboBox.addActionListener(this);
        mainComboBox.addItemListener(this);
        //prevent action events from being fired when the up/down arrow keys are used
        //mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        //  Create sub combo box with multiple models
        subComboBox = new JComboBox();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        subComboBox.addItemListener(this);
        getContentPane().add(subComboBox, BorderLayout.EAST);
        String[] subItems0 = {"Columna"};
        subItems.put(items[0], subItems0);
        String[] subItems1 = {"Columna","Cve_cli","Nombre", "Direccion", "Mail"};
        subItems.put(items[1], subItems1);
        String[] subItems2 = {"Columna","No_empleado","Nombre", "Comision"};
        subItems.put(items[2], subItems2);
        String[] subItems3 = {"Columna","Cve_articulo","Descripcion", "Costo", "Cantidad"};
        subItems.put(items[3], subItems3);
        String[] subItems4 = {"Columna","Fecha", "Total", "Cve_cli","No_empleado"};
        subItems.put(items[4], subItems4);
    }
    
    public JComboBox getMainComboBox() {
        return mainComboBox;
    }

    public JComboBox getSubComboBox() {
        return subComboBox;
    }
    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        String item = (String) mainComboBox.getSelectedItem();
        Object o = subItems.get(item);
        if (o == null) {
            subComboBox.setModel(new DefaultComboBoxModel());
        } else {
            subComboBox.setModel(new DefaultComboBoxModel((String[]) o));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == mainComboBox) {
                if (mainComboBox.getSelectedIndex() != 0) {

                }
            } 
        }
    }



}
