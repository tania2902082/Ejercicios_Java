package ahorcado.java;
import java.util.Scanner;

public class Ahorcado {
    private static final String[] PALABRAS = {"lapiz", "prueba", "positivo", "baño", "tristeza", "embarazo", "salon"};
    private static final int MAX_INTENTOS = 10;

    private String palabraSecreta;
    private char[] palabraDescubierta;
    private int intentosRestantes;
    private boolean juegoTerminado;

    public Ahorcado() {
        iniciarJuego();
    }

    private void iniciarJuego() {
        palabraSecreta = PALABRAS[(int) (Math.random() * PALABRAS.length)];
        palabraDescubierta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraDescubierta.length; i++) {
            palabraDescubierta[i] = '_';
        }
        intentosRestantes = MAX_INTENTOS;
        juegoTerminado = false;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        while (!juegoTerminado) {
            mostrarProgreso();
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            if (!adivinar(letra)) {
                intentosRestantes--;
                if (intentosRestantes == 0) {
                    juegoTerminado = true;
                    System.out.println("¡Perdiste! La palabra era: " + palabraSecreta);
                }
            } else if (String.valueOf(palabraDescubierta).equals(palabraSecreta)) {
                juegoTerminado = true;
                System.out.println("¡Felicidades!, ganaste");
            }
        }
        scanner.close();
    }

    private void mostrarProgreso() {
        System.out.print("Palabra: ");
        for (char c : palabraDescubierta) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private boolean adivinar(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraDescubierta[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public static void main(String[] args) {
        Ahorcado juego = new Ahorcado();
        juego.jugar();
    }
}
