/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nuevoshilos;

/**
 *
 * @author Ideapad Gaming 3
 */
public class Nuevoshilos {
    public static void main(String[] args) {
        Impresora lenovo = new Impresora("lenovo");
        Impresora hp = new Impresora("hp");

        Thread hilo1 = new Thread(new ImprimirHilo(lenovo, "Hilo 1"));
        Thread hilo2 = new Thread(new ImprimirHilo(lenovo, "Hilo 2"));
        Thread hilo3 = new Thread(new ImprimirHilo(hp, "Hilo 3"));
        Thread hilo4 = new Thread(new ImprimirHilo(hp, "Hilo 4"));

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }

    static class Impresora {
        private String nombre;

        public Impresora(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void imprimir(String hilo) {
            try {
                System.out.println(hilo + " impreso en " + this.getNombre());
                Thread.sleep(2000);
                System.out.println(hilo + " se imprimio en " + this.getNombre());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ImprimirHilo implements Runnable {
        private final Impresora impresora;
        private String hilo;

        public ImprimirHilo(Impresora impresora, String hilo) {
            this.impresora = impresora;
            this.hilo = hilo;
        }

        @Override
        public void run() {
            synchronized (impresora) {
                impresora.imprimir(hilo);
            }
        }
    }
}

