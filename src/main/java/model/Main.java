package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 1. Construcción de la aplicación
        Aplicacion aplicacion = new Aplicacion(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        // 2. Construcción de usuarios
        Usuario usuario1 = new Usuario(
                "juan@gmail.com",
                "juan123",
                "Clave123!",
                "Juan Pérez",
                LocalDate.of(2000, 5, 10),
                "Costarricense",
                "123456789"
        );

        Usuario usuario2 = new Usuario(
                "maria@gmail.com",
                "maria456",
                "Maria123!",
                "María Rodríguez",
                LocalDate.of(1998, 8, 20),
                "Costarricense",
                "987654321"
        );

        // 3. Construcción de administrador
        Administrador administrador1 = new Administrador(
                "admin@gmail.com",
                "admin1",
                "Admin123!"
        );

        // 4. Construcción de canción
        Cancion cancion1 = new Cancion(
                "Bohemian Rhapsody",
                "Rock",
                "Queen",
                "Freddie Mercury",
                LocalDate.of(1975, 10, 31),
                "A Night at the Opera",
                "bohemian_rhapsody.jpg",
                new BigDecimal("1.99")
        );

        // PRUEBA 1: Registrar objetos en las listas
        aplicacion.registrarUsuario(usuario1);
        aplicacion.registrarUsuario(usuario2);
        aplicacion.registrarAdministrador(administrador1);
        aplicacion.registrarCancion(cancion1);

        // Mostrar las listas
        System.out.println("===== USUARIOS =====");
        aplicacion.mostrarUsuarios();

        System.out.println("\n===== ADMINISTRADORES =====");
        aplicacion.mostrarAdministradores();

        System.out.println("\n===== CANCIONES =====");
        aplicacion.mostrarCanciones();

        // PRUEBA 2: Calificar una canción
        System.out.println("\n===== PRUEBA DE CALIFICACIÓN =====");
        System.out.println(cancion1.calificar(4.5));
        System.out.println(cancion1);

        // Mostrar aplicación
        System.out.println("\n===== APLICACIÓN =====");
        System.out.println(aplicacion);
    }
}