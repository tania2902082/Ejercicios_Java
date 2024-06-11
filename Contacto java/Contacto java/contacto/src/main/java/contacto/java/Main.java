package contacto.java;
import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    String nombre;
    String telefono;
    String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
}

class Agenda {
    ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    public void eliminarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.nombre.equals(nombre)) {
                contactos.remove(contacto);
                System.out.println("Contacto eliminado correctamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.nombre.equals(nombre)) {
                System.out.println("Nombre: " + contacto.nombre);
                System.out.println("Teléfono: " + contacto.telefono);
                System.out.println("Email: " + contacto.email);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos) {
                System.out.println("Nombre: " + contacto.nombre);
                System.out.println("Teléfono: " + contacto.telefono);
                System.out.println("Email: " + contacto.email);
            }
        }
    }
}

public class Main {
    public static void mostrarMenu() {
        System.out.println("\n*** Menú de Agenda ***");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Mostrar todos los contactos");
        System.out.println("5. Salir");
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el email del contacto: ");
                    String email = scanner.nextLine();
                    Contacto contacto = new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(contacto);
                    break;

                case "2":
                    System.out.print("Ingrese el nombre del contacto que desea eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;

                case "3":
                    System.out.print("Ingrese el nombre del contacto que desea buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    agenda.buscarContacto(nombreBuscar);
                    break;

                case "4":
                    agenda.mostrarContactos();
                    break;

                case "5":
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
