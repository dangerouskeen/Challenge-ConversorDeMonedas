import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsultaMoneda {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/32a928161830cb12c53acc70/latest/";
    private static final String[] MONEDAS = {"ARS", "BOB", "BRL", "CLP", "COP", "MXN", "PEN", "USD"};

    public String seleccionarMoneda(Scanner scanner) {
        for (int i = 0; i < MONEDAS.length; i++) {
            System.out.printf("%d) %s%n", i + 1, MONEDAS[i]);
        }

        int opcion;
        do {
            System.out.print("Seleccione una opción (1-" + MONEDAS.length + "): ");
            opcion = Integer.parseInt(scanner.nextLine());
        } while (opcion < 1 || opcion > MONEDAS.length);

        return MONEDAS[opcion - 1];
    }

    public Moneda convertirMoneda(String monedaBase, String monedaDestino, double monto) {
        try {
            URL url = new URL(URL_API + monedaBase);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            if (conexion.getResponseCode() == 200) {
                InputStreamReader lector = new InputStreamReader(conexion.getInputStream());
                JsonObject respuestaJson = JsonParser.parseReader(lector).getAsJsonObject();
                JsonObject tasas = respuestaJson.getAsJsonObject("conversion_rates");
                double tasaDestino = tasas.get(monedaDestino).getAsDouble();

                lector.close();
                return new Moneda(monedaBase, monedaDestino, monto, monto * tasaDestino);
            } else {
                throw new RuntimeException("Error al obtener las tasas de cambio.");
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo completar la conversión: " + e.getMessage());
        }
    }
}
