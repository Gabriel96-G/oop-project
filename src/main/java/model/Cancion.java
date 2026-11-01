package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cancion implements Reproducible{

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
    private static int contador = 1; // compartido para las canciones - static = pertenece a la clase, se comparte.
    private int id; // propio de cada canción

    // Métodos
    // Constructor completo
    public Cancion (String nombre, String genero, String artista, String compositor, LocalDate fechaLanzamiento, String album, String caratula, BigDecimal precio){
        setNombre(nombre);
        this.genero = genero;
        setArtista(artista);
        this.compositor = compositor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.album = album;
        this.caratula = caratula;
        this.calificacion = 0.0; // no es un parametro que se recibe pero si una asignación. - Sin calificación porque es un objeto recién creado.
        this.cantidadCalificaciones = 0;  // no es un parametro que se recibe pero si una asignación. - Misma situación.
        setPrecio(precio);
        this.id = contador;
        contador++; // usa el contador para dar un id único y luego lo sube.
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

    public int getId() {
        return id;
    }

    // Setters - Agrega valor y lo cambia
    public void setNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Debe indicar el nombre de la canción");
        }
        this.nombre = nombre.trim();
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setArtista(String artista){
        if (artista == null || artista.trim().isEmpty()){
            throw new IllegalArgumentException("Debe indicar el nombre del artista");
        }
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
        if (calificacion < 0.0 || calificacion > 5.0) {
            throw new IllegalArgumentException("La calificación debe estar entre 0.0 y 5.0");
        }
        this.calificacion = calificacion;
    }


    public void setCantidadCalificaciones(int cantidadCalificaciones){
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public void setPrecio(BigDecimal precio){
        if (precio == null){
            throw new IllegalArgumentException("Debe indicar un precio");
        }
        if (precio.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (precio.stripTrailingZeros().scale() > 2){
            throw new IllegalArgumentException("Use un máximo de dos decimales");
        }
        this.precio = precio;
    }

    // toString()
    public String toString() {
        return "ID: " + id +
                "\nNombre Canción: " + nombre +
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
            throw new IllegalArgumentException("La calificación debe estar entre 0.0 y 5.0");
            // throw corta el método
        }

        double total = calificacion * cantidadCalificaciones; // toma la suma de todas las calificaciones anteriores
        total = total + nota; // agrego la nota nueva
        cantidadCalificaciones = cantidadCalificaciones + 1; // el promedio nuevo tiene que repartirse entre una calificación más

        calificacion = Math.round((total / cantidadCalificaciones) * 10) / 10.0;

        return "La calificación ha sido registrada con éxito";
    }

    @Override
    public String reproducir(){
        return "La canción " + nombre + " se está reproduciendo";
    }

    @Override
    public String detener(){
        return "La canción " + nombre + " ha sido detenida";
    }


}
