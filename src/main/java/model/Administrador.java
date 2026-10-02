package model;

public class Administrador {

    //ATRIBUTOS
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    //CONSTRUCTOR
    public Administrador(String correoElectronico, String nombreUsuario, String contrasenia) {
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
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

    public String toString() {
        return "Administrador:" +
                "\nCorreo: " + correoElectronico +
                "\nNombre de usuario: " + nombreUsuario;
    }

    //MÉTODOS
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
}