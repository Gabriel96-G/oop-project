package vista;

import model.Aplicacion;
import model.Cuenta;
import model.Usuario;
import model.ListaReproduccion;
import java.util.Scanner;

public class Menu {

    // ATRIBUTO PARA LEER DATOS DEL TECLADO
    private final Scanner scanner = new Scanner(System.in);

    // REFERENCIA A LA APLICACIÓN
    private final Aplicacion aplicacion;

    // CUENTA QUE TIENE LA SESIÓN ACTIVA
    private Cuenta cuentaActual;

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

        // LIMPIAR CUALQUIER SESIÓN ANTERIOR
        cuentaActual = null;

        try {
            Cuenta cuenta = aplicacion.iniciarSesion(nombreUsuario, contrasenia);

            // GUARDAR LA CUENTA AUTENTICADA
            cuentaActual = cuenta;
            System.out.println("Inicio de sesión exitoso.");
            System.out.println("Usuario: " + cuenta.getNombreUsuario());
            System.out.println("Rol: " + cuenta.getRol());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ABRIR EL MENÚ SEGÚN EL TIPO DE CUENTA
        if (cuentaActual instanceof Usuario) {
            ejecutarMenuUsuario();
        } else if (cuentaActual instanceof model.Administrador) {
            ejecutarMenuAdministrador();
        }
    }

    // MÉTODO PARA MOSTRAR EL MENÚ DEL USUARIO
    public void mostrarMenuUsuario() {

        System.out.println("\n===== MENÚ DE USUARIO =====");
        System.out.println("1. Consultar catálogo de canciones");
        System.out.println("2. Consultar mis listas de reproducción");
        System.out.println("0. Cerrar sesión");

    }

    // MÉTODO PARA EJECUTAR EL MENÚ DEL USUARIO
    public void ejecutarMenuUsuario() {

        if (!(cuentaActual instanceof Usuario usuario)) {
            System.out.println("Debe iniciar sesión como usuario.");
            return;
        }

        String opcion;

        do {
            mostrarMenuUsuario();
            opcion = leerOpcion();

            switch (opcion) {

                case "1":
                    System.out.println("\n===== CATÁLOGO DE CANCIONES =====");
                    aplicacion.mostrarCanciones();
                    break;

                case "2":
                    System.out.println("\n===== MIS LISTAS DE REPRODUCCIÓN =====");

                    if (usuario.getListasReproduccion().isEmpty()) {
                        System.out.println("No tienes listas de reproducción.");
                    } else {
                        for (ListaReproduccion lista : usuario.getListasReproduccion()) {
                            System.out.println(lista);
                        }
                    }
                    break;

                case "0":
                    cuentaActual = null;
                    System.out.println("Sesión cerrada.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (!opcion.equals("0"));
    }

    // MÉTODO PARA MOSTRAR EL MENÚ DEL ADMINISTRADOR
    public void mostrarMenuAdministrador() {

        System.out.println("\n===== MENÚ DE ADMINISTRADOR =====");
        System.out.println("1. Consultar usuarios registrados");
        System.out.println("2. Consultar catálogo de canciones");
        System.out.println("0. Cerrar sesión");

    }

    // MÉTODO PARA EJECUTAR EL MENÚ DEL ADMINISTRADOR
    public void ejecutarMenuAdministrador() {

        if (!(cuentaActual instanceof model.Administrador)) {
            System.out.println("Debe iniciar sesión como administrador.");
            return;
        }

        String opcion;

        do {
            mostrarMenuAdministrador();
            opcion = leerOpcion();

            switch (opcion) {

                case "1":
                    System.out.println("\n===== USUARIOS REGISTRADOS =====");
                    aplicacion.mostrarUsuarios();
                    break;

                case "2":
                    System.out.println("\n===== CATÁLOGO DE CANCIONES =====");
                    aplicacion.mostrarCanciones();
                    break;

                case "0":
                    cuentaActual = null;
                    System.out.println("Sesión cerrada.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (!opcion.equals("0"));
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


