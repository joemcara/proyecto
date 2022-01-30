/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Premio;
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
public class PremioController implements Initializable {

    @FXML
    private Button BttnRegis;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtPuesto;
    @FXML
    private TextField txtNombresC;
    @FXML
    private TextField txtDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registro(ActionEvent event) {
        int idPremio = Util.nextID("criterio.txt");
        String puesto = txtPuesto.getText();
        String descrpcion = txtDescripcion.getText(); 
        String nombre = txtNombresC.getText();
        int idConcurso = Premio.idDueño(nombre);
        Premio nuevo = new Premio(idPremio,Integer.parseInt(puesto),descrpcion,idConcurso); 
        nuevo.saveFile("premio.txt");     
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Ha sido registrado Correctamente");
        a.show();  
        txtPuesto.clear();
        txtDescripcion.clear();
        txtNombresC.clear();
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
    
