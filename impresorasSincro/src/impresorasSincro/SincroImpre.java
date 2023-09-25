package impresorasSincro;

public class SincroImpre {

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
                System.out.println(hilo + " impreso en una impresora " + this.getNombre());
                Thread.sleep(2000);
                System.out.println(hilo + " se imprimio en una impresora " + this.getNombre());
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
    
    public static void main(String[] args) {
        Impresora numero1 = new Impresora("vieja");
        Impresora numero2 = new Impresora("nueva");

        Thread hilo1 = new Thread(new ImprimirHilo(numero1, "Hilo 1"));
        Thread hilo2 = new Thread(new ImprimirHilo(numero1, "Hilo 2"));
        Thread hilo3 = new Thread(new ImprimirHilo(numero2, "Hilo 3"));
        Thread hilo4 = new Thread(new ImprimirHilo(numero2, "Hilo 4"));

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
