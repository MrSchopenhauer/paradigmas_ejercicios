package HiperCuboFinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

public class HipercuboApp {
    private JFrame frame;
    private JComboBox<Integer> emisorComboBox;
    private JComboBox<Integer> destinoComboBox;
    private JTextArea rutaTextArea;
    private HipercuboPanel hipercuboPanel;
    private RutaCompartida rutaCompartida;
    private String rutaActual;

    private static final int HIPERCUBO_SIZE = 400;
    static final int NODOS = 16;
    static final int[] NODO_X = {150, 250, 200, 300, 150, 250, 200, 300, 150, 250, 200, 300, 150, 250, 200, 300};
    static final int[] NODO_Y = {50, 50, 100, 100, 200, 200, 250, 250, 350, 350, 400, 400, 500, 500, 550, 550};

    public HipercuboApp() {
        // Crear una nueva ventana JFrame con título
        frame = new JFrame("Hipercubo 4D");
        // Configurar la acción de cierre de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establecer el tamaño de la ventana
        frame.setSize(800, 600);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel(new BorderLayout());

        // Crear un panel para dibujar el hipercubo y las rutas
        hipercuboPanel = new HipercuboPanel();
        panel.add(hipercuboPanel, BorderLayout.CENTER);

        // Crear un subpanel para los controles
        JPanel controlPanel = new JPanel(new FlowLayout());

        // Crear etiquetas
        JLabel emisorLabel = new JLabel("Emisor:");
        JLabel destinoLabel = new JLabel("Destino:");

        // Crear listas desplegables (combobox) con elementos
        emisorComboBox = new JComboBox<>(getComboBoxItems());
        destinoComboBox = new JComboBox<>(getComboBoxItems());

        // Crear un botón y un área de texto
        JButton calcularRutaButton = new JButton("Calcular Ruta");
        rutaTextArea = new JTextArea(3, 20);
        rutaTextArea.setEditable(false);

        // Agregar componentes al panel de controles
        controlPanel.add(emisorLabel);
        controlPanel.add(emisorComboBox);
        controlPanel.add(destinoLabel);
        controlPanel.add(destinoComboBox);
        controlPanel.add(calcularRutaButton);
        controlPanel.add(new JLabel("Ruta:"));
        controlPanel.add(new JScrollPane(rutaTextArea));

        // Crear el recurso compartido para la ruta
        rutaCompartida = new RutaCompartida();
        rutaActual = "";

        // Configurar el botón para calcular la ruta en segundo plano
        calcularRutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int emisor = (int) emisorComboBox.getSelectedItem();
                int destino = (int) destinoComboBox.getSelectedItem();

                // Crear un productor y un consumidor para generar y pintar la ruta
                Thread productor = new Thread(new Productor(emisor, destino, rutaCompartida));
                Thread consumidor = new Thread(new Consumidor(hipercuboPanel, rutaCompartida));

                // Iniciar los hilos
                productor.start();
                consumidor.start();

                // Actualizar el contenido del TextArea con la ruta calculada
                rutaTextArea.setText(rutaActual);
            }
        });

        // Agregar el panel de controles al panel principal
        panel.add(controlPanel, BorderLayout.SOUTH);

        // Agregar el panel principal a la ventana y hacerla visible
        frame.add(panel);
        frame.setVisible(true);
    }

    private Integer[] getComboBoxItems() {
        // Devolver un arreglo de enteros del 0 al 15
        return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    }

    public static void main(String[] args) {
        // Crear y mostrar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new HipercuboApp());
    }
}

class HipercuboPanel extends JPanel {
    private String ruta;

    public HipercuboPanel() {
        setPreferredSize(new Dimension(800, 600));
        ruta = null;
    }

    public void dibujarRuta(String ruta) {
        this.ruta = ruta;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        // Dibuja el hipercubo
        for (int i = 0; i < HipercuboApp.NODOS; i++) {
            for (int j = i + 1; j < HipercuboApp.NODOS; j++) {
                if ((i != 4 || j != 8) && (i != 8 || j != 4) && ((i < 8 && j < 8) || (i >= 8 && j >= 8))) {
                    int xorResult = i ^ j;
                    int numSetBits = Integer.bitCount(xorResult);

                    if (numSetBits == 1) {
                        // Si hay un solo bit en 1 en la operación XOR, significa que los nodos están conectados.
                        int midX = (HipercuboApp.NODO_X[i] + HipercuboApp.NODO_X[j]) / 2;
                        int midY = (HipercuboApp.NODO_Y[i] + HipercuboApp.NODO_Y[j]) / 2;

                        g2d.drawLine(HipercuboApp.NODO_X[i], HipercuboApp.NODO_Y[i], midX, midY);
                        g2d.drawLine(midX, midY, HipercuboApp.NODO_X[j], HipercuboApp.NODO_Y[j]);
                    }
                }
            }
        }

        // Dibuja los nodos y la ruta si existe
        for (int i = 0; i < HipercuboApp.NODOS; i++) {
            g2d.fillOval(HipercuboApp.NODO_X[i] - 10, HipercuboApp.NODO_Y[i] - 10, 20, 20);
            g2d.drawString(Integer.toString(i), HipercuboApp.NODO_X[i], HipercuboApp.NODO_Y[i]);
        }

        // Dibuja la ruta si existe
        if (ruta != null) {
            String[] nodos = ruta.split(" -> ");
            g2d.setColor(Color.RED);
            for (int i = 0; i < nodos.length - 1; i++) {
                int nodo1 = Integer.parseInt(nodos[i]);
                int nodo2 = Integer.parseInt(nodos[i + 1]);
                g2d.drawLine(HipercuboApp.NODO_X[nodo1], HipercuboApp.NODO_Y[nodo1], HipercuboApp.NODO_X[nodo2], HipercuboApp.NODO_Y[nodo2]);
            }
        }
    }
}

class RutaCompartida {
    private String ruta;
    private boolean rutaDisponible;

    public RutaCompartida() {
        ruta = null;
        rutaDisponible = false;
    }

    public synchronized void producirRuta(String ruta) {
        while (rutaDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.ruta = ruta;
        rutaDisponible = true;
        notifyAll();
    }

    public synchronized String consumirRuta() {
        while (!rutaDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        String rutaConsumida = ruta;
        ruta = null;
        rutaDisponible = false;
        notifyAll();
        return rutaConsumida;
    }
}

class Productor implements Runnable {
    private int emisor;
    private int destino;
    private RutaCompartida rutaCompartida;

    public Productor(int emisor, int destino, RutaCompartida rutaCompartida) {
        this.emisor = emisor;
        this.destino = destino;
        this.rutaCompartida = rutaCompartida;
    }

    @Override
    public void run() {
        String ruta = calcularRuta(emisor, destino);
        rutaCompartida.producirRuta(ruta);
    }

    private String calcularRuta(int emisor, int destino) {
        // Crear un StringBuilder para construir la cadena de ruta
        StringBuilder ruta = new StringBuilder();
        ruta.append(emisor);
        // Calcular la ruta en el hipercubo
        while (emisor != destino) {
            int diferencia = emisor ^ destino;
            int movimiento = 1 << Integer.numberOfTrailingZeros(diferencia);
            emisor ^= movimiento;
            ruta.append(" -> ").append(emisor);
        }
        // Devolver la cadena de ruta como resultado
        return ruta.toString();
    }
}

class Consumidor implements Runnable {
    private HipercuboPanel hipercuboPanel;
    private RutaCompartida rutaCompartida;

    public Consumidor(HipercuboPanel hipercuboPanel, RutaCompartida rutaCompartida) {
        this.hipercuboPanel = hipercuboPanel;
        this.rutaCompartida = rutaCompartida;
    }

    @Override
    public void run() {
        while (true) {
            String ruta = rutaCompartida.consumirRuta();
            hipercuboPanel.dibujarRuta(ruta);
        }
    }
}