public record Moneda(String monedaBase, String monedaDestino, double monto, double resultado) {
    @Override
    public String toString() {
        return String.format("%.2f %s equivalen a %.2f %s", monto, monedaBase, resultado, monedaDestino);
    }
}
