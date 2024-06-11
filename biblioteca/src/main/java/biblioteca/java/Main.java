package biblioteca.java;

import java.util.*;

class Libro {
    String titulo;
    String autor;
    String ISBN;
    int anoPublicacion;

    // Constructor
    public Libro(String titulo, String autor, String ISBN, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anoPublicacion = anoPublicacion;
    }
}

class Biblioteca {
    List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.titulo.contains(titulo)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.autor.contains(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> mostrarTodosLosLibros() {
        return libros;
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. prestar libros");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            scanner.nextLine(); // consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anoPublicacion = scanner.nextInt();
                    biblioteca.agregarLibro(new Libro(titulo, autor, ISBN, anoPublicacion));
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    titulo = scanner.nextLine();
                    List<Libro> librosPorTitulo = biblioteca.buscarPorTitulo(titulo);
                    for (Libro libro : librosPorTitulo) {
                        System.out.println(libro.titulo + ", " + libro.autor);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el autor del libro a buscar: ");
                    autor = scanner.nextLine();
                    List<Libro> librosPorAutor = biblioteca.buscarPorAutor(autor);
                    for (Libro libro : librosPorAutor) {
                        System.out.println(libro.titulo + ", " + libro.autor);
                    }
                    break;
                case 4:
                    List<Libro> todosLosLibros = biblioteca.mostrarTodosLosLibros();
                    for (Libro libro : todosLosLibros) {
                        System.out.println(libro.titulo + ", " + libro.autor);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el Nombre del Autor ");
                    autor = scanner.nextLine();
                    List<Libro> prestaLibros = biblioteca.buscarPorAutor(autor);
                    for (Libro libro : prestaLibros) {
                        System.out.println(libro.titulo + ", " + libro.autor);
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
}