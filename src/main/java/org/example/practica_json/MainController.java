package org.example.practica_json;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class MainController {

    private TextField txtTitulo, txtFecha, txtGenero, txtDirector;
    private ListView<Pelicula> lvPeliculas;
    private Button btnImportar;

    private final PeliculaDAO peliculaDAO = new PeliculaDAO();

    @FXML
    protected void onBtnImportarClick() {

        lvPeliculas.getItems().clear();
        try {
            List<Pelicula> peliculas = peliculaDAO.obtenerPeliculas();
            lvPeliculas.setItems(FXCollections.observableList(peliculas));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}