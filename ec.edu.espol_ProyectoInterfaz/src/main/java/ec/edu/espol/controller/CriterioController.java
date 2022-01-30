/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Util;
import ec.edu.espol.proyecto_interfaz.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yoser
 */
public class CriterioController implements Initializable {

    private TextField txtPlace;
    private TextField txtFile;
    private TextField txtText;
    @FXML
    private Button btnBack;
    @FXML
    private TextField TxtPuesto;
    @FXML
    private TextField TxtNombre;
    @FXML
    private TextField TxtDescripcion;
    @FXML
    private Button BttnRegis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registro(ActionEvent event) {
        int idCriterio= Util.nextID("criterio.txt");
        String puesto = TxtPuesto.getText();
        String nombre = TxtNombre.getText();
        String descripcion= TxtDescripcion.getText();
        int idConcurso = Criterio.idConcurso(nombre);   
        Criterio nuevo = new Criterio(idCriterio, Integer.parseInt(puesto), descripcion, idConcurso);
        nuevo.saveFile("criterio.txt");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Ha sido registrado Correctamente");
        a.show();
        TxtPuesto.clear();
        TxtNombre.clear();
        TxtDescripcion.clear();
    }

    @FXML
    private void volver(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
            Parent root = fxmlLoader.load();
            MenuController jc = fxmlLoader.getController();
            App.scene.setRoot(root);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
