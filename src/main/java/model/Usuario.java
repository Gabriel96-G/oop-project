package model;

import java.time.LocalDate;

public class Usuario {

    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String cedula;

    public Usuario(String correoElectronico, String nombreUsuario, String contrasenia, String nombreCompleto, LocalDate fechaNacimiento, String nacionalidad, String cedula) {
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
    }
}