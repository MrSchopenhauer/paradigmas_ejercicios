package Carrera;

import javax.swing.*;
public class HiloCorredor implements Runnable {
    private Corredor corredor;
    private PistaMonitor pistaMonitor;

    public HiloCorredor(Corredor corredor, PistaMonitor pistaMonitor) {
        this.corredor = corredor;
        this.pistaMonitor = pistaMonitor;
    }

    @Override
    public void run() {
        pistaMonitor.avanzar(corredor);
    }
}