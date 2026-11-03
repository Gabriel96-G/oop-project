package vista;

import model.Aplicacion;
import model.Cuenta;
import java.util.Scanner;

public class Menu {

    // ATRIBUTO PARA LEER DATOS DEL TECLADO
    private final Scanner scanner = new Scanner(System.in);

    // REFERENCIA A LA APLICACIÓN
    private final Aplicacion aplicacion;

    // CONSTRUCTOR
    public Menu(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    // MÉTODO PARA INICIAR SESIÓN
    public void iniciarSesion() {

        System.out.println("\n===== INICIO DE SESIÓN =====");

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine().trim();

        System.out.print("Contraseña: ");
        String contrasenia = scanner.nextLine();

        try {
            Cuenta cuenta = aplicacion.iniciarSesion(nombreUsuario, contrasenia);

            System.out.println("Inicio de sesión exitoso.");
            System.out.println("Usuario: " + cuenta.getNombreUsuario());
            System.out.println("Rol: " + cuenta.getRol());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // MÉTODO PARA MOSTRAR EL MENÚ PRINCIPAL
    public void mostrarMenuPrincipal() {

        System.out.println("\n===== APLICACIÓN MUSICAL =====");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Consultar catálogo de canciones");
        System.out.println("0. Salir");

    }

    // MÉTODO PARA LEER LA OPCIÓN SELECCIONADA
    public String leerOpcion() {

        System.out.print("Seleccione una opción: ");
        return scanner.nextLine().trim();

    }
    // MÉTODO PARA EJECUTAR EL MENÚ PRINCIPAL
    public void ejecutar() {

        String opcion;

        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();

            switch (opcion) {

                case "1":
                    iniciarSesion();
                    break;

                case "2":
                    System.out.println("\n===== CATÁLOGO DE CANCIONES =====");
                    aplicacion.mostrarCanciones();
                    break;

                case "0":
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (!opcion.equals("0"));
    }
}


