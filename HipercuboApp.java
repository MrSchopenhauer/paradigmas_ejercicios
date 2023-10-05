package Carrera2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HipercuboApp {
    private JFrame frame;
    private JComboBox<Integer> emisorComboBox;
    private JComboBox<Integer> destinoComboBox;
    private JTextArea rutaTextArea;
    private Random random;

    public HipercuboApp() {
        frame = new JFrame("Hipercubo 4D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400); // Aumenta el tamaño de la ventana para dar espacio al dibujo

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel emisorLabel = new JLabel("Emisor:");
        JLabel destinoLabel = new JLabel("Destino:");

        emisorComboBox = new JComboBox<>(getComboBoxItems());
        destinoComboBox = new JComboBox<>(getComboBoxItems());

        JButton calcularRutaButton = new JButton("Calcular Ruta");
        rutaTextArea = new JTextArea(3, 20);
        rutaTextArea.setEditable(false);

        inputPanel.add(emisorLabel);
        inputPanel.add(emisorComboBox);
        inputPanel.add(destinoLabel);
        inputPanel.add(destinoComboBox);
        inputPanel.add(calcularRutaButton);
        inputPanel.add(new JLabel("Ruta:"));
        inputPanel.add(new JScrollPane(rutaTextArea));

        random = new Random();

        calcularRutaButton.addActionListener(e -> {
            int emisor = (int) emisorComboBox.getSelectedItem();
            int destino = (int) destinoComboBox.getSelectedItem();
            rutaTextArea.setText(calcularRuta(emisor, destino));
        });

        // Crea un nuevo panel para dibujar los cubos
        JPanel dibujoPanel = new LaminaConCubos();
        mainPanel.add(inputPanel);
        mainPanel.add(dibujoPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private Integer[] getComboBoxItems() {
        return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    }

    private String calcularRuta(int emisor, int destino) {
        StringBuilder ruta = new StringBuilder();
        ruta.append(emisor);
        while (emisor != destino) {
            int diferencia = emisor ^ destino;
            int movimiento = 1 << Integer.numberOfTrailingZeros(diferencia);
            emisor ^= movimiento;
            ruta.append(" -> ").append(emisor);
        }
        return ruta.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HipercuboApp());
    }
}

class LaminaConCubos extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja los cubos aquí según las coordenadas
        g.drawLine(50, 100, 300, 100);
        g.drawLine(300, 100, 300, 350);
        g.drawLine(300, 350, 50, 350);
        g.drawLine(50, 350, 50, 100);

        g.drawLine(200, 50, 450, 50);
        g.drawLine(450, 50, 450, 300);
        g.drawLine(450, 300, 200, 300);
        g.drawLine(200, 300, 200, 50);

        g.drawLine(50, 100, 200, 50);
        g.drawLine(300, 100, 450, 50);
        g.drawLine(300, 350, 450, 300);
        g.drawLine(50, 350, 200, 300);

        g.drawLine(700, 100, 950, 100);
        g.drawLine(950, 100, 950, 350);
        g.drawLine(950, 350, 700, 350);
        g.drawLine(700, 350, 700, 100);

        g.drawLine(850, 50, 1100, 50);
        g.drawLine(1100, 50, 1100, 300);
        g.drawLine(1100, 300, 850, 300);
        g.drawLine(850, 300, 850, 50);

        g.drawLine(700, 100, 850, 50);
        g.drawLine(950, 100, 1100, 50);
        g.drawLine(950, 350, 1100, 300);
        g.drawLine(700, 350, 850, 300);
    }
}
