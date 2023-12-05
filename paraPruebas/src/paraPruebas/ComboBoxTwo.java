package paraPruebas;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ComboBoxTwo extends JFrame implements ActionListener, ItemListener {

    private JComboBox mainComboBox;
    private JComboBox subComboBox;
    private Hashtable<Object, Object> subItems = new Hashtable<Object, Object>();

    public ComboBoxTwo() {
        String[] items = {"Selecciona tabla", "Cliente", "Empleado", "Articulo", "Factura"};
        mainComboBox = new JComboBox(items);
        mainComboBox.addActionListener(this);
        mainComboBox.addItemListener(this);
        //prevent action events from being fired when the up/down arrow keys are used
        //mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        //  Create sub combo box with multiple models
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        subComboBox.addItemListener(this);
        getContentPane().add(subComboBox, BorderLayout.EAST);
        String[] subItems1 = {"Selecciona columna", "Nombre", "Direccion", "Mail"};
        subItems.put(items[1], subItems1);
        String[] subItems2 = {"Selecciona columna", "Nombre", "Comision"};
        subItems.put(items[2], subItems2);
        String[] subItems3 = {"Selecciona columna", "Descripcion", "Costo", "Cantidad"};
        subItems.put(items[3], subItems3);
        String[] subItems4 = {"Selecciona columna", "Fecha", "Total", "Cve_cliente","No_empleado"};
        subItems.put(items[4], subItems4);
//      mainComboBox.setSelectedIndex(1);
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