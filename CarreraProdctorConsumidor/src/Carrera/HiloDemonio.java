package Carrera;

import javax.swing.*;
import java.util.List;

public class HiloDemonio implements Runnable {
    private List<Corredor> corredores;
    private JPanel panel;
    private static final int MAX_ASTERISCOS = 20; 
    private boolean carreraTerminada = false;

    public HiloDemonio(List<Corredor> corredores, JPanel panel) {
        this.corredores = corredores;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (!carreraTerminada) {
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean alMenosUnoTerminado = false;
            for (Corredor corredor : corredores) {
                if (corredor.getX() >= 720) {
                    alMenosUnoTerminado = true;
                    break; 
                }
            }

            if (alMenosUnoTerminado) {
                carreraTerminada = true;
            } else {
                // Elimina los asteriscos más antiguos de cada corredor
                for (Corredor corredor : corredores) {
                    corredor.removeOldAsteriscos(MAX_ASTERISCOS, panel);
                }
            }
        }
    }
}