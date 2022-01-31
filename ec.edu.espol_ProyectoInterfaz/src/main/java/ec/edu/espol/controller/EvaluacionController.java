/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Evaluacion;
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
 * @author onlyw
 */
public class EvaluacionController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnRegistro;
    @FXML
    private TextField txtemail;
    private TextField txtNombre;
    @FXML
    private TextField txtNota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void registrar(ActionEvent event) {
        int idIncripcion = Util.nextID("evaluacion.txt"); 
        int idCriterio = Util.nextID("criterio.txt");    
        String email = txtemail.getText();
        String nota= txtNota.getText();
        Evaluacion nuevo = new Evaluacion(email, idIncripcion, idCriterio, Double.parseDouble(nota));
        nuevo.saveFile("evaluacion.txt");        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Ha sido registrado Correctamente");
        a.show();
        txtemail.clear();
        txtNota.clear();      
    }
    
}
