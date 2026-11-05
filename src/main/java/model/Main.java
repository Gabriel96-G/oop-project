
package model;

import vista.Menu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 1. CONSTRUIR LA APLICACIÓN
        Aplicacion aplicacion = new Aplicacion(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        // 2. REGISTRAR CANCIONES INICIALES
        Cancion cancion1 = new Cancion(
                "Bohemian Rhapsody",
                "Rock",
                "Queen",
                "Freddie Mercury",
                LocalDate.of(1975, 10, 31),
                "A Night at the Opera",
                "bohemian_rhapsody.jpg",
                new BigDecimal("1.99")
        );

        Cancion cancion2 = new Cancion(
                "Imagine",
                "Pop",
                "John Lennon",
                "John Lennon",
                LocalDate.of(1971, 9, 9),
                null,
                null,
                new BigDecimal("0.99")
        );

        aplicacion.registrarCancion(cancion1);
        aplicacion.registrarCancion(cancion2);

        // 3. INICIAR EL MENÚ INTERACTIVO
        Menu menu = new Menu(aplicacion);
        menu.ejecutar();
    }
}
