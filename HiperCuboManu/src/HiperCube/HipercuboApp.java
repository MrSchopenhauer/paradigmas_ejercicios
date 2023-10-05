package HiperCube;
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
    private LaminaConCubo laminaConCubo;

    public HipercuboApp() {
        frame = new JFrame("Hipercubo 4D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        JLabel emisorLabel = new JLabel("Emisor:");
        JLabel destinoLabel = new JLabel("Destino:");

        emisorComboBox = new JComboBox<>(getComboBoxItems());
        destinoComboBox = new JComboBox<>(getComboBoxItems());

        JButton calcularRutaButton = new JButton("Calcular Ruta");
        JButton resaltarRutaButton = new JButton("Resaltar Ruta");
        JButton resetButton = new JButton("Reset");

        rutaTextArea = new JTextArea(3, 20);
        rutaTextArea.setEditable(false);

        inputPanel.add(emisorLabel);
        inputPanel.add(emisorComboBox);
        inputPanel.add(destinoLabel);
        inputPanel.add(destinoComboBox);
        inputPanel.add(calcularRutaButton);
        inputPanel.add(resaltarRutaButton);
        inputPanel.add(resetButton);
        inputPanel.add(new JLabel("Ruta:"));
        inputPanel.add(new JScrollPane(rutaTextArea));

        random = new Random();

        calcularRutaButton.addActionListener(e -> {
            int emisor = (int) emisorComboBox.getSelectedItem();
            int destino = (int) destinoComboBox.getSelectedItem();
            rutaTextArea.setText(calcularRuta(emisor, destino));
            laminaConCubo.setRuta(emisor, destino);
        });

        resaltarRutaButton.addActionListener(e -> {
            laminaConCubo.resaltarSiguienteArista();
        });

        resetButton.addActionListener(e -> {
            laminaConCubo.reset();
            rutaTextArea.setText("");
        });

        laminaConCubo = new LaminaConCubo();
        mainPanel.add(inputPanel);
        mainPanel.add(laminaConCubo);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private Integer[] getComboBoxItems() {
        return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
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

class LaminaConCubo extends JPanel {
    private int emisor = -1;
    private int destino = -1;
    private int resaltarArista = -1;

    public LaminaConCubo() {
    }

    public void setRuta(int emisor, int destino) {
        this.emisor = emisor;
        this.destino = destino;
        this.resaltarArista = -1;
        repaint();
    }

    public void resaltarSiguienteArista() {
        if (resaltarArista < 11) {
            resaltarArista++;
            repaint();
        }
    }

    public void reset() {
        emisor = -1;
        destino = -1;
        resaltarArista = -1;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja el cubo con aristas de igual longitud y perspectiva
        int[] x = {100, 200, 300, 200, 100, 200, 300, 200};
        int[] y = {50, 100, 50, 0, 150, 200, 150, 100};
        int[][] aristas = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {4, 5}, {5, 6}, {6, 7}, {7, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};

        for (int i = 0; i < x.length; i++) {
            g.drawString(Integer.toString(i), x[i], y[i]);
        }

        for (int i = 0; i < aristas.length; i++) {
            int x1 = x[aristas[i][0]];
            int y1 = y[aristas[i][0]];
            int x2 = x[aristas[i][1]];
            int y2 = y[aristas[i][1]];
            if ((aristas[i][0] == emisor && aristas[i][1] == destino) || (aristas[i][0] == destino && aristas[i][1] == emisor)) {
                g.setColor(Color.RED);
            } else if (resaltarArista >= 0 && resaltarArista == i) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawLine(x1, y1, x2, y2);
        }
    }
}