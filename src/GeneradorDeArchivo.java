import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {
    private static final String NOMBRE_ARCHIVO = "historial_conversor.json";

    public void guardarJson(Moneda nuevaConversion) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<RegistroHistorial> historial = cargarHistorial();

        // Crear un nuevo registro con la fecha y hora actuales
        String fechaHoraActual = obtenerFechaHoraActual();
        RegistroHistorial registro = new RegistroHistorial(
                nuevaConversion.monedaBase(),
                nuevaConversion.monedaDestino(),
                nuevaConversion.monto(),
                nuevaConversion.resultado(),
                fechaHoraActual
        );

        historial.add(registro);

        // Guardar el historial actualizado en el archivo JSON
        FileWriter escritor = new FileWriter(NOMBRE_ARCHIVO);
        escritor.write(gson.toJson(historial));
        escritor.close();
    }

    private List<RegistroHistorial> cargarHistorial() {
        Gson gson = new Gson();
        try (FileReader lector = new FileReader(NOMBRE_ARCHIVO)) {
            RegistroHistorial[] historial = gson.fromJson(lector, RegistroHistorial[].class);
            if (historial != null) {
                return new ArrayList<>(List.of(historial));
            }
        } catch (IOException e) {
            // El archivo no existe o no se pudo leer
        }
        return new ArrayList<>();
    }

    private String obtenerFechaHoraActual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }

    /**
     * Clase anidada para representar un registro del historial.
     */
    private static class RegistroHistorial {
        private final String monedaBase;
        private final String monedaDestino;
        private final double monto;
        private final double resultado;
        private final String fechaHora;

        public RegistroHistorial(String monedaBase, String monedaDestino, double monto, double resultado, String fechaHora) {
            this.monedaBase = monedaBase;
            this.monedaDestino = monedaDestino;
            this.monto = monto;
            this.resultado = resultado;
            this.fechaHora = fechaHora;
        }
    }
}
