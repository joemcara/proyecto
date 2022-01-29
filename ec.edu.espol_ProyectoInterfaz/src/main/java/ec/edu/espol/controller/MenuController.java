/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyecto_interfaz.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Yoser
 */
public class MenuController implements Initializable {

    @FXML
    private Pane welcomeIMG;
    @FXML
    private MenuItem registroConcurso;
    @FXML
    private MenuItem irCriterio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgShow();
    }

    @FXML
    private void showInfo(ActionEvent event) {

    }

    public void imgShow() {
        Image img = new Image("img/" + "prueba.jpg");
        ImageView imgview = new ImageView(img);
        imgview.setFitWidth(300);
        imgview.setFitHeight(300);
        welcomeIMG.getChildren().add(imgview);
    }

    @FXML
    private void irConcurso(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Concurso.fxml"));
            Parent root = fxmlLoader.load();
            ConcursoController jc = fxmlLoader.getController();
            App.scene.setRoot(root);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void irCriterio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("criterio.fxml"));
            Parent root = fxmlLoader.load();
            CriterioController jc = fxmlLoader.getController();
            App.scene.setRoot(root);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
