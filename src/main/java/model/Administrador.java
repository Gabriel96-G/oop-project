package model;

public class Administrador {

    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    public Administrador(String correoElectronico, String nombreUsuario, String contrasenia) {
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
}