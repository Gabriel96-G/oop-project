package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cancion {

    // Atributos (10)
    private String nombre;
    private String genero;
    private String artista; // solista o banda
    private String compositor;
    private LocalDate fechaLanzamiento;
    private String album;
    private String caratula;
    private double calificacion;
    private int cantidadCalificaciones;
    private BigDecimal precio;

    // Métodos
    // Constructor completo
    public Cancion (String nombre, String genero, String artista, String compositor, LocalDate fechaLanzamiento, String album, String caratula, BigDecimal precio){
        this.nombre = nombre;
        this.genero = genero;
        this.artista = artista;
        this.compositor = compositor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.album = album;
        this.caratula = caratula;
        this.calificacion = 0.0; // no es un parametro que se recibe pero si una asignación. - Sin calificación porque es un objeto recién creado.
        this.cantidadCalificaciones = 0;  // no es un parametro que se recibe pero si una asignación. - Misma situación.
        this.precio = precio;
    }

    // Getters - Devuelve información
    public String getNombre(){
        return nombre;
    }

    public String getGenero(){
        return genero;
    }

    public String getArtista(){
        return artista;
    }

    public String getCompositor(){
        return compositor;
    }

    public LocalDate getFechaLanzamiento(){
        return fechaLanzamiento;
    }

    public String getAlbum(){
        return album;
    }

    public String getCaratula(){
        return caratula;
    }

    public double getCalificacion(){
        return calificacion;
    }

    public int getCantidadCalificaciones(){
        return cantidadCalificaciones;
    }

    public BigDecimal getPrecio(){
        return precio;
    }

    // Setters - Agrega valor y lo cambia
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setArtista(String artista){
        this.artista = artista;
    }

    public void setCompositor(String compositor){
        this.compositor = compositor;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento){
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setAlbum(String album){
        this.album = album;
    }

    public void setCaratula(String caratula){
        this.caratula = caratula;
    }

    public void setCalificacion(double calificacion){
        this.calificacion = calificacion;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones){
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public void setPrecio(BigDecimal precio){
        this.precio = precio;
    }

    // toString()
    public String toString() {
        return "Nombre Canción: " + nombre +
                "\nGénero: " + genero +
                "\nArtista: " + artista +
                "\nCompositor: " + compositor +
                "\nFecha de lanzamiento: " + fechaLanzamiento +
                "\nÁlbum: " + (album == null ? "Sin álbum" : album) + // para que no salga como álbum = null - Resultados: "Sin álbum o "álbum"
                "\nCarátula: " + (caratula == null ? "Carátula predeterminada" : caratula) + // Resultados: "Carátula predeterminada" o "caratula"
                "\nCalificación: " + calificacion +
                "\nCalificaciones recibidas: " + cantidadCalificaciones +
                "\nPrecio: $" + precio;
    }

    // equals ()
    public boolean equals(Cancion cancion){
        return getNombre().equals(cancion.getNombre()) && getArtista().equals(cancion.getArtista());
    }

    // Método calificar
    public String calificar (double nota){
        if (nota < 0.0 || nota > 5.0){
            return "La calificación debe estar entre 0.0 y 5.0";
        }

        double total = calificacion * cantidadCalificaciones; // toma la suma de todas las calificaciones anteriores
        total = total + nota; // agrego la nota nueva
        cantidadCalificaciones = cantidadCalificaciones + 1; // el promedio nuevo tiene que repartirse entre una calificación más

        calificacion = Math.round((total / cantidadCalificaciones) * 10) / 10.0;

        return "La calificación ha sido registrada con éxito";
    }

}
