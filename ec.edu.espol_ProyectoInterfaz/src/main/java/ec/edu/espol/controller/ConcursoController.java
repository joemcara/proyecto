/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Util;
import ec.edu.espol.proyecto_interfaz.App;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yoser
 */
public class ConcursoController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnRegistro;
    @FXML
    private TextField txtNombre;
    @FXML
    private DatePicker txtDate;
    @FXML
    private DatePicker txtDateStart;
    @FXML
    private DatePicker txtDateEnd;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtTematica;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
            Parent root = fxmlLoader.load();
            MenuController jc = fxmlLoader.getController();
            App.scene.setRoot(root);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void registrar(ActionEvent event) {
        int id = Util.nextID("concurso.txt");
        String nombreC = txtNombre.getText();
        LocalDate fechaA = txtDate.getValue();
        LocalDate fechaStart = txtDateStart.getValue();
        LocalDate fechaEnd = txtDateEnd.getValue();
        double precio = Double.parseDouble(txtPrecio.getText());
        String tematica = txtTematica.getText();
        Concurso nuevo = new Concurso(id,nombreC,fechaA,fechaStart,fechaEnd,tematica,precio);
        nuevo.saveFile("concurso.txt");
        // Va un if :v de comprobación creo no che
        Alert a = new Alert(AlertType.CONFIRMATION,"Ha sido registrado Correctamente");
        a.show();
        txtNombre.clear();
        txtDate.getEditor().clear();
        txtDateStart.getEditor().clear();
        txtDateEnd.getEditor().clear();        
        txtPrecio.clear();
        txtTematica.clear();
        //
    }

}
