package palabra;
import java.util.*;

public class AnalisisDeTexto {
    public static void main(String[] args) {
        // Texto de ejemplo
        String contenido = "Este es un texto de ejemplo.";
        
        // Procesamiento del texto
        String[] palabras = contenido.split("\\s+");
        String[] oraciones = contenido.split("[.!?]");
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        int longitudTotalPalabras = 0;
        
        for (String palabra : palabras) {
            palabra = palabra.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ]", ""); // Elimina signos de puntuación
            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            longitudTotalPalabras += palabra.length();
        }
        
        // Estadísticas
        int totalPalabras = palabras.length;
        int totalOraciones = oraciones.length;
        String palabraMasFrecuente = Collections.max(frecuenciaPalabras.entrySet(), Map.Entry.comparingByValue()).getKey();
        double longitudPromedioPalabras = (double) longitudTotalPalabras / totalPalabras;
        
        // Resultados
        System.out.println("Número total de palabras: " + totalPalabras);
        System.out.println("Número total de oraciones: " + totalOraciones);
        System.out.println("Palabra más frecuente: " + palabraMasFrecuente);
        System.out.printf("Longitud promedio de las palabras: %.2f\n", longitudPromedioPalabras);
    }
}