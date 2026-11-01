package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion implements Reproducible {

    // Atributos
    private String nombre;
    private LocalDate fechaCreacion;
    private List<Cancion> canciones;

    // Métodos
    // Constructor completo
    public ListaReproduccion (String nombre, LocalDate fechaCreacion, List<Cancion> canciones){
        setNombre(nombre);
        setFechaCreacion(fechaCreacion);
        setCanciones(canciones);
    }

    // Constructor por sobrecarga -> fecha de hoy y con lista vacía
    public ListaReproduccion (String nombre){
        this(nombre, LocalDate.now(), new ArrayList<>());
    }
    // Getters
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Cancion> getCanciones() { // copia con solo lectura para que no se puedan saltar agregarCancion()
        return java.util.Collections.unmodifiableList(new ArrayList<>(canciones));
    }

    // La calificacion no se guarda y calcula el promedio de las canciones de la lista.
    public double getCalificacion(){
        if (canciones.isEmpty()){
            return 0.0;
        }
        double suma = 0.0;
        for (Cancion cancion : canciones){
            suma = suma + cancion.getCalificacion();
        }
        return Math.round((suma / canciones.size()) * 10) / 10.0;
    }


    // Setters
    public void setNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Debe indicar el nombre de la lista");
        }
        this.nombre = nombre.trim();
    }

    public void setFechaCreacion(LocalDate fechaCreacion){
        if (fechaCreacion == null){
            throw new IllegalArgumentException("Debe indicar la fecha de creación");
        }
        this.fechaCreacion = fechaCreacion;
    }

    public void setCanciones(List<Cancion> canciones) {
        if (canciones == null){
            throw new IllegalArgumentException("Debe indicar la lista de canciones");
        }
        this.canciones = new ArrayList<>(canciones);
    }

    // Método agregarCancion
    public void agregarCancion(Cancion cancion){
        if (cancion == null){
            throw new IllegalArgumentException("Debe indicar la canción");
        }
        for (Cancion existente : canciones){
            if (existente.equals(cancion)){
                throw new IllegalStateException("La canción ya está en la lista"); // IllegalArgumentException - “el valor que me pasaste es inválido”. IllegalStateException - “el valor está bien, pero el estado actual no permite esto”.
            }
        }
        canciones.add(cancion);
    }

    // Método quitarCancion
    public void quitarCancion(Cancion cancion){
        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).equals(cancion)){
                canciones.remove(i);
                return; // ya la quité, termino el método
            }
        }
        throw new IllegalStateException("La canción no está en la lista"); // si llegó aquí, no estaba
    }

    // Métodos de la interfaz Reproducible
    @Override
    public String reproducir(){
        return "La lista " + nombre + " se está reproduciendo (" + canciones.size() + " canciones)";
    }

    @Override
    public String detener(){
        return "La lista " + nombre + " ha sido detenida";
    }

    // toString()
    @Override
    public String toString() {
        String detalle = "";
        for (Cancion cancion : canciones){
            detalle = detalle + "\n  - " + cancion.getNombre() + " (" + cancion.getArtista() + ")";
        }
        return "Lista de reproducción: " + nombre +
                "\nFecha de creación: " + fechaCreacion +
                "\nCalificación: " + getCalificacion() +
                "\nCanciones: " + canciones.size() +
                detalle;
    }

}
