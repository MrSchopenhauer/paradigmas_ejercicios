package vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import programaFacturas.ModeloBusquedas;

public class Reporte extends JFrame {
    private JTable jTable;
    private DefaultTableModel tablaModelo;
    private Statement statement;
    private JComboBox<String> tableComboBox;
    private JComboBox<String> parameterComboBox;
    private JTextField busqueda;
    private JComboBox<String> specificSearchComboBox;
    private ModeloBusquedas modeloBusquedas;
    
    private BoxOpciones boxOpciones;

    public Reporte(Statement statement) {
    	this.statement = statement;
        setTitle("Motor de busqueda");
        setSize(1400, 500);
        
        BoxOpciones boxOpciones = new BoxOpciones();


        tablaModelo = new DefaultTableModel();


        jTable = new JTable(tablaModelo);


        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


        JPanel searchPanel = new JPanel();
        tableComboBox = boxOpciones.mainComboBox; 
        parameterComboBox = boxOpciones.subComboBox; 
        busqueda = new JTextField(20);
        JButton searchButton = new JButton("Buscar");


        specificSearchComboBox = new JComboBox<>(new String[]{"", "Articulos en Factura por Fecha", "Stock Menor a 5", "Empleados con Facturas en Octubre"});


        tableComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedTableObject = tableComboBox.getSelectedItem();
                Object selectedParameterObject = parameterComboBox.getSelectedItem();


                if (selectedTableObject == null || selectedParameterObject == null) {
                    JOptionPane.showMessageDialog(null, "Por favor selecciona una columna");
                    return; 
                }

                String selectedTable = selectedTableObject.toString();
                String selectedParameter = selectedParameterObject.toString();
                String searchTerm = busqueda.getText().trim();


                String selectedSpecificSearch = specificSearchComboBox.getSelectedItem().toString();

                if (!selectedSpecificSearch.isEmpty()) {
                    try {
                        performSpecificSearch(selectedTable, selectedSpecificSearch, searchTerm);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    fetchDataFromDatabase(selectedTable, selectedParameter, searchTerm);
                }
            }
        });
        
        searchPanel.add(new JLabel("Selecciona la tabla: "));
        searchPanel.add(tableComboBox);
        searchPanel.add(new JLabel("Columna: "));
        searchPanel.add(parameterComboBox);
        searchPanel.add(new JLabel("Busqueda: "));
        searchPanel.add(busqueda);
        searchPanel.add(searchButton);

        // Add specific search ComboBox
        searchPanel.add(new JLabel("Requerida: "));
        searchPanel.add(specificSearchComboBox);

        // Add search panel to the JFrame
        getContentPane().add(searchPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);

    }



    private void performSpecificSearch(String selectedTable, String selectedSpecificSearch, String searchTerm) throws SQLException {
        // Implement specific search logic based on the selected option
        String sql;
        switch (selectedSpecificSearch) {
            case "Articulos en Factura por Fecha":
                // Perform specific search for "Articulos en Factura por Fecha"
                sql = "SELECT Articulo.* " +
                        "FROM Articulo " +
                        "JOIN Detalle ON Articulo.Cve_Articulo = Detalle.Cve_articulo " +
                        "JOIN Factura ON Detalle.No_factura = Factura.No_factura " +
                        "WHERE Factura.Fecha = "+"'"+searchTerm+"'";

                try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(sql)) {

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {

                        tablaModelo.setRowCount(0);
                        tablaModelo.setColumnCount(0);

   
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();


                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            tablaModelo.addColumn(metaData.getColumnName(columnIndex));
                        }


                        while (resultSet.next()) {
                            Object[] rowData = new Object[columnCount];
                            for (int i = 1; i <= columnCount; i++) {
                                rowData[i - 1] = resultSet.getObject(i);
                            }
                            tablaModelo.addRow(rowData);
                        }
                    }
                } catch (SQLException e) {
        	        JOptionPane.showMessageDialog(null, "Debes colocar un valor en la fecha");
                    e.printStackTrace();
                }

                break;


            case "Stock Menor a 5":

                
                sql = "SELECT Descripcion, Cantidad "
                	    + "FROM Articulo "
                	    + "WHERE Cantidad < 5";
                
                try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(sql)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {

                        tablaModelo.setRowCount(0);
                        tablaModelo.setColumnCount(0);


                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        // Set column names in the table model
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            tablaModelo.addColumn(metaData.getColumnName(columnIndex));
                        }

                        // Populate the table model with data from the ResultSet
                        while (resultSet.next()) {
                            Object[] rowData = new Object[columnCount];
                            for (int i = 1; i <= columnCount; i++) {
                                rowData[i - 1] = resultSet.getObject(i);
                            }
                            tablaModelo.addRow(rowData);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                
                break;
            case "Empleados con Facturas en Octubre":
            	sql = "SELECT Empleado.No_empleado, Empleado.Nombre, Factura.* "
            		    + "FROM Empleado "
            		    + "JOIN Factura ON Empleado.No_empleado = Factura.No_empleado "
            		    + "WHERE MONTH(Factura.Fecha) = 10";

            		try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(sql)) {
            		    try (ResultSet resultSet = preparedStatement.executeQuery()) {
            		        // Clear existing data in the table model
            		        tablaModelo.setRowCount(0);
            		        tablaModelo.setColumnCount(0);

            		        // Get metadata about the ResultSet (columns, types, etc.)
            		        ResultSetMetaData metaData = resultSet.getMetaData();
            		        int columnCount = metaData.getColumnCount();

            		        // Set column names in the table model
            		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            		            tablaModelo.addColumn(metaData.getColumnName(columnIndex));
            		        }

            		        // Populate the table model with data from the ResultSet
            		        while (resultSet.next()) {
            		            Object[] rowData = new Object[columnCount];
            		            for (int i = 1; i <= columnCount; i++) {
            		                rowData[i - 1] = resultSet.getObject(i);
            		            }
            		            tablaModelo.addRow(rowData);
            		        }
            		    }
            		} catch (SQLException e) {
            		    e.printStackTrace();
            		}
                break;
            default:
                System.out.println("Valor no valido");
                break;
        }
    }
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void fetchDataFromDatabase(String selectedTable, String selectedParameter, String searchTerm) {
        // Clear existing data in the table model
        tablaModelo.setRowCount(0);
        tablaModelo.setColumnCount(0);

        // Check if the selected column is "Columna"
        if ("Columna".equals(selectedParameter)) {
            showMessage("Selecciona una columna", "Aviso");
            return; // Stop further processing
        }

        modeloBusquedas = new ModeloBusquedas();
        String sql;

        try {
            // Special case for "Factura" table
            if ("Factura".equals(selectedTable)) {
                sql = "SELECT Factura.*, Detalle.* FROM Factura LEFT JOIN Detalle ON Factura.No_factura = Detalle.No_factura";
            } else if (searchTerm.isEmpty()) {
                sql = "SELECT * FROM " + selectedTable;
                 // Stop further processing
            } else if (isNumeric(searchTerm)) {
                // Use placeholders for the parameters in the query
                sql = modeloBusquedas.opcionesEnteros(selectedTable, selectedParameter, searchTerm);
            } else {
                // Fetch data based on the selected parameter and search term{
                    sql = "SELECT * FROM " + selectedTable + " WHERE " + selectedParameter + " LIKE ?";
                    searchTerm = "%" + searchTerm + "%";
            }

            try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(sql)) {
                // Set the parameter for the query with placeholders
                if (!isNumeric(searchTerm) && !searchTerm.isEmpty() && !(selectedTable == "Fecha") ) {
                    preparedStatement.setString(1, searchTerm);
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Get metadata about the ResultSet (columns, types, etc.)
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Set column names in the table model
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        tablaModelo.addColumn(metaData.getColumnName(columnIndex));
                    }

                    // Populate the table model with data from the ResultSet
                    while (resultSet.next()) {
                        Object[] rowData = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            rowData[i - 1] = resultSet.getObject(i);
                        }
                        tablaModelo.addRow(rowData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String message, String messageType) {
        JOptionPane.showMessageDialog(null, message, messageType, JOptionPane.WARNING_MESSAGE);
    }


}