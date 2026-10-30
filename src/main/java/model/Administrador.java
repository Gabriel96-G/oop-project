package model;

public class Administrador extends Cuenta {
    // CONSTRUCTOR
    public Administrador(String correo, String usuario, String clave, String confirmacion) {
        super(correo, usuario, clave);
        validarContrasenia(clave, confirmacion);
    }

    // MÉTODOS
    @Override
    public String getRol() {
        return "ADMINISTRADOR";
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Administrador:\nCorreo: " + getCorreoElectronico()
                + "\nNombre de usuario: " + getNombreUsuario();
    }
}
