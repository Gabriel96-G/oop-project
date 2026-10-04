package model;

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

        // 4. Registro en las listas
        aplicacion.registrarUsuario(usuario1);
        aplicacion.registrarUsuario(usuario2);

        aplicacion.registrarAdministrador(administrador1);

        // 5. Mostrar las listas
        System.out.println("===== USUARIOS =====");
        aplicacion.mostrarUsuarios();

        System.out.println("\n===== ADMINISTRADORES =====");
        aplicacion.mostrarAdministradores();

        // 6. Mostrar la aplicación
        System.out.println("\n===== APLICACIÓN =====");
        System.out.println(aplicacion);
    }
}