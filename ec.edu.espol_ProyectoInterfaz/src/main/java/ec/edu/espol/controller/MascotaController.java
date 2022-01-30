/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Mascota;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author onlyw
 */
public class MascotaController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField TxtNombre;
    @FXML
    private TextField TxtTipo;
    @FXML
    private TextField TxtRaza;
    @FXML
    private DatePicker txtDate;
    @FXML
    private Button btnRegistro;
    @FXML
    private TextField TxtCorreo;

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
        int idMascota = Util.nextID("mascota.txt");
        int idDueño = Mascota.idDueño(TxtCorreo.getText());
        String nombre = TxtNombre.getText();
        String raza = TxtRaza.getText(); 
        LocalDate fechaNac= txtDate.getValue();
        String tipo = TxtTipo.getText();
        Mascota nuevo = new Mascota(idMascota,nombre,raza,fechaNac,tipo,idDueño); 
        nuevo.saveFile("mascota.txt");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Ha sido registrado Correctamente");
        a.show();
        TxtNombre.clear();
        TxtRaza.clear();
        TxtTipo.clear();
        TxtCorreo.clear();
        txtDate.getEditor().clear();
    }
    
}
