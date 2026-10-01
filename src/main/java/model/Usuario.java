package model;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    //ATRIBUTOS
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String cedula;
    private BigDecimal saldo = new BigDecimal("4.99");
    private List<Cancion> cancionesCompradas = new ArrayList<>();
    private List<ListaReproduccion> listasReproduccion = new ArrayList<>();

    //CONSTRUCTOR
    public Usuario(String correoElectronico, String nombreUsuario, String contrasenia, String nombreCompleto, LocalDate fechaNacimiento, String nacionalidad, String cedula) {
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
    }

    //GETTERS Y SETTERS
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Cancion> getCancionesCompradas() {
        return cancionesCompradas;
    }

    public void setCancionesCompradas(List<Cancion> cancionesCompradas) {
        this.cancionesCompradas = cancionesCompradas;
    }

    public List<ListaReproduccion> getListasReproduccion() {
        return listasReproduccion;
    }

    public void setListasReproduccion(List<ListaReproduccion> listasReproduccion) {
        this.listasReproduccion = listasReproduccion;
    }

    //public String toString()

    //MÉTODOS
    public boolean esMayorDeEdad() {
        if (fechaNacimiento == null) {
            return false;
        }
        LocalDate fechaLimite = LocalDate.now().minusYears(18);
        if (fechaNacimiento.isAfter(fechaLimite)) {
            return false;
        }
        return true;
    }

    public String cambiarContrasenia(String contraseniaActual, String nuevaContrasenia, String confirmacion) {
        if (contraseniaActual == null || nuevaContrasenia == null || confirmacion == null) {
            return "Debe completar todos los campos";
        }
        if (!contraseniaActual.equals(this.contrasenia)) {
            return "La contraseña actual es incorrecta";
        }
        if (nuevaContrasenia.equals(this.contrasenia)) {
            return "La contraseña tiene que ser diferente";
        }
        if (!nuevaContrasenia.equals(confirmacion)) {
            return "La nueva contraseña y su confirmación no coinciden";
        }
        if (nuevaContrasenia.length() < 8 || nuevaContrasenia.length() > 12) {
            return "La contraseña debe tener entre 8 y 12 caracteres";
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (int i = 0; i < nuevaContrasenia.length(); i++) {
            char caracter = nuevaContrasenia.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(caracter)) {
                tieneNumero = true;
            } else if (!Character.isLetterOrDigit(caracter)
                    && !Character.isWhitespace(caracter)) {
                tieneEspecial = true;
            }
        }
        if (!tieneMayuscula || !tieneMinuscula || !tieneNumero || !tieneEspecial) {
            return "La contraseña debe incluir mayúscula, minúscula, número y carácter especial";
        }
        this.contrasenia = nuevaContrasenia;
        return "La contraseña se cambió correctamente";
    }

    public String recargarSaldo(BigDecimal monto) {
        if (monto == null) {
            return "Debe incluir monto";
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return "El monto debe ser mayor que 0";
        }
        this.saldo = this.saldo.add(monto);
        return "El saldo fue agregado correctamente";
    }

    // public boolean tieneCancion(Cancion cancion)
    // public String comprarCancion(Cancion cancion)
    // public String agregarListaReproduccion(ListaReproduccion lista)





}