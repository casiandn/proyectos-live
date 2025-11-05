import java.util.Scanner;

public class HistorialTerminal {

    // Nodo doblemente enlazado
    static class Comando {
        String texto;
        Comando anterior;
        Comando siguiente;

        Comando(String texto) {
            this.texto = texto;
        }
    }

    static class Terminal {
        private Comando actual = null;  // posición actual
        private Comando ultimo = null;  // fin del historial
        private Comando primero = null; // inicio del historial

        // Guardar un nuevo comando al final
        public void ejecutar(String texto) {
            Comando nuevo = new Comando(texto);
            if (primero == null) {
                primero = ultimo = nuevo;
            } else {
                ultimo.siguiente = nuevo;
                nuevo.anterior = ultimo;
                ultimo = nuevo;
            }
            actual = null; // se resetea posición
            System.out.println("💻 Ejecutando: " + texto);
        }

        // Navegar hacia atrás (como ↑)
        public void anterior() {
            if (ultimo == null) {
                System.out.println("📂 Sin historial todavía.");
                return;
            }
            if (actual == null) {
                actual = ultimo;
            } else if (actual.anterior != null) {
                actual = actual.anterior;
            } else {
                System.out.println("🚫 Estás en el primer comando.");
                return;
            }
            System.out.println("⬆️  " + actual.texto);
        }

        // Navegar hacia adelante (como ↓)
        public void siguiente() {
            if (actual == null) {
                System.out.println("🚫 No hay siguiente.");
                return;
            }
            if (actual.siguiente != null) {
                actual = actual.siguiente;
                System.out.println("⬇️  " + actual.texto);
            } else {
                System.out.println("🆕 Línea vacía...");
                actual = null;
            }
        }

        // Mostrar todo el historial
        public void mostrar() {
            if (primero == null) {
                System.out.println("📭 Historial vacío.");
                return;
            }
            System.out.println("\n🧠 HISTORIAL DE COMANDOS:");
            Comando temp = primero;
            while (temp != null) {
                System.out.print("➡️  " + temp.texto + "\n");
                temp = temp.siguiente;
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Terminal term = new Terminal();

        System.out.println("💻 Terminal enlazada iniciada. Escribe comandos.");
        System.out.println("(↑ = 'up', ↓ = 'down', 'show' = historial, 'exit' = salir)\n");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();

            switch (input.toLowerCase()) {
                case "up" -> term.anterior();
                case "down" -> term.siguiente();
                case "show" -> term.mostrar();
                case "exit" -> {
                    System.out.println("👋 Cerrando terminal.");
                    return;
                }
                default -> term.ejecutar(input);
            }
        }
    }
}

