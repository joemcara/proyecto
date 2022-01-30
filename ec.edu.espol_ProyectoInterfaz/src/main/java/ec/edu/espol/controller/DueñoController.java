/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Dueño;
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
public class DueñoController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnRegistro;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;

    /**
     * Initializes the controller class.
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
        int idDueño = Util.nextID("Dueños.txt");
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtPhone.getText();
        String email = txtEmail.getText();
        Dueño nuevo = new Dueño(idDueño,nombres,apellidos,telefono,email);
        nuevo.saveFile("dueño.txt");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Ha sido registrado Correctamente");
        a.show();   
        txtNombres.clear();
        txtApellidos.clear();
        txtPhone.clear();
        txtEmail.clear();        
    }
    
}
