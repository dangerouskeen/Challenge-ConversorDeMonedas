import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n--- Conversor de Monedas ---");
                System.out.println("Seleccione la moneda base:");
                String monedaBase = consultaMoneda.seleccionarMoneda(scanner);

                System.out.println("\nSeleccione la moneda destino:");
                String monedaDestino = consultaMoneda.seleccionarMoneda(scanner);

                if (monedaBase.equals(monedaDestino)) {
                    System.out.println("La moneda base y destino son iguales. Intente nuevamente.");
                    continue;
                }

                System.out.print("\nIngrese el monto a convertir: ");
                double monto = Double.parseDouble(scanner.nextLine());

                Moneda moneda = consultaMoneda.convertirMoneda(monedaBase, monedaDestino, monto);
                System.out.println("\nResultado de la conversión: " + moneda);

                generadorDeArchivo.guardarJson(moneda);

                System.out.println("\n¿Desea realizar otra conversión? (1: Sí, 2: No)");
                continuar = "1".equals(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar el archivo: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Gracias por usar el conversor de monedas.");
    }
}
