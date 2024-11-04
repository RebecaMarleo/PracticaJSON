package org.example.practica_json;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public List<Pelicula> obtenerPeliculas() throws SQLException {
        ArrayList<Pelicula> peliculas = null;
        try {
            peliculas =
                    JSON_MAPPER.readValue(new File("src/main/resources/peliculas.json"),
                            JSON_MAPPER.getTypeFactory().constructCollectionType
                                    (ArrayList.class, Pelicula.class));

            for (Pelicula p : peliculas) {
                System.out.print(p.getId() + " ");
                System.out.print(p.getTitulo() + " ");
                System.out.print(p.getFecha() + " ");
                System.out.print(p.getDirector() + " ");
                System.out.print(p.getGenero() + " ");
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return peliculas;
    }
}
