package model;

public abstract class Cuenta {
    // ATRIBUTOS
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    // CONSTRUCTOR
    protected Cuenta(String correo, String usuario, String clave) {
        setCorreoElectronico(correo);
        setNombreUsuario(usuario);
        setContrasenia(clave);
    }

    // MÉTODOS
    protected static String requerido(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty())
            throw new IllegalArgumentException("Debe indicar " + campo);
        return valor.trim();
    }

    public static void validarContrasenia(String clave, String confirmacion) {
        if (clave == null || clave.length() < 8 || clave.length() > 12)
            throw new IllegalArgumentException("La contraseña debe tener entre 8 y 12 caracteres");
        boolean may = false, min = false, num = false, especial = false;
        for (char c : clave.toCharArray()) {
            if (Character.isWhitespace(c))
                throw new IllegalArgumentException("La contraseña no admite espacios");
            may |= Character.isUpperCase(c);
            min |= Character.isLowerCase(c);
            num |= Character.isDigit(c);
            especial |= !Character.isLetterOrDigit(c);
        }
        if (!may || !min || !num || !especial)
            throw new IllegalArgumentException("Incluya mayúscula, minúscula, número y carácter especial");
        if (!clave.equals(confirmacion))
            throw new IllegalArgumentException("Las contraseñas no coinciden");
    }

    public boolean autenticar(String usuario, String clave) {
        return nombreUsuario.equals(usuario) && contrasenia.equals(clave);
    }

    public abstract String getRol();

    // GETTERS Y SETTERS
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String correo = requerido(correoElectronico, "correo");
        if (!correo.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+"))
            throw new IllegalArgumentException("Correo inválido");
        this.correoElectronico = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = requerido(nombreUsuario, "usuario");
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        validarContrasenia(contrasenia, contrasenia);
        this.contrasenia = contrasenia;
    }

    // MÉTODOS
    public String cambiarContrasenia(String contraseniaActual, String nuevaContrasenia, String confirmacion) {
        if (contraseniaActual == null || nuevaContrasenia == null || confirmacion == null) {
            throw new IllegalArgumentException("Debe completar todos los campos");
        }
        if (!contraseniaActual.equals(this.contrasenia)) {
            throw new IllegalArgumentException("La contraseña actual es incorrecta");
        }
        validarContrasenia(nuevaContrasenia, confirmacion);
        if (nuevaContrasenia.equals(this.contrasenia)) {
            throw new IllegalArgumentException("La contraseña tiene que ser diferente");
        }
        this.contrasenia = nuevaContrasenia;
        return "La contraseña se cambió correctamente";
    }
}
