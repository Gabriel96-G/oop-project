package model;

import java.util.List;

public class Aplicacion {

    // ATRIBUTOS
    private List<Usuario> usuarios;
    private List<Administrador> administradores;
    private List<Cancion> canciones;

    // CONSTRUCTOR COMPLETO
    public Aplicacion(List<Usuario> usuarios,
                      List<Administrador> administradores,
                      List<Cancion> canciones) {

        this.usuarios = usuarios;
        this.administradores = administradores;
        this.canciones = canciones;
    }

    // GETTERS Y SETTERS
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    // MÉTODO PARA INICIAR SESIÓN
    public Cuenta iniciarSesion(String nombreUsuario, String contrasenia) {

        if (nombreUsuario == null || contrasenia == null) {
            throw new IllegalArgumentException(
                    "Debe ingresar el usuario y la contraseña"
            );
        }

        // Buscar entre los administradores
        for (Administrador administrador : administradores) {

            if (administrador.autenticar(nombreUsuario, contrasenia)) {
                return administrador;
            }
        }

        // Buscar entre los usuarios
        for (Usuario usuario : usuarios) {

            if (usuario.autenticar(nombreUsuario, contrasenia)) {
                return usuario;
            }
        }

        throw new IllegalStateException(
                "Nombre de usuario o contraseña incorrectos"
        );
    }

    // MÉTODO PARA BUSCAR UNA CANCIÓN POR ID
    public Cancion buscarCancionPorId(int id) {

        for (Cancion cancion : canciones) {

            if (cancion.getId() == id) {
                return cancion;
            }
        }

        throw new IllegalArgumentException(
                "No existe una canción con el ID indicado"
        );
    }

    // MÉTODOS PARA REGISTRAR OBJETOS
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void registrarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public void registrarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // MÉTODOS PARA MOSTRAR LAS LISTAS
    public void mostrarUsuarios() {

        System.out.println("USUARIOS REGISTRADOS");

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
            System.out.println();
        }
    }

    public void mostrarAdministradores() {

        System.out.println("ADMINISTRADORES REGISTRADOS");

        for (int i = 0; i < administradores.size(); i++) {
            System.out.println(administradores.get(i));
            System.out.println();
        }
    }

    public void mostrarCanciones() {

        System.out.println("CANCIONES REGISTRADAS");

        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(canciones.get(i));
            System.out.println();
        }
    }

    // toString()
    public String toString() {
        return "Aplicación:"
                + "\nUsuarios: " + usuarios
                + "\nAdministradores: " + administradores
                + "\nCanciones: " + canciones;
    }
}