/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.MiembroJurado;
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
public class MiembroJuradoController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnRegistro;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPerfil;

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
        int idJurado = Util.nextID("miembroJurado.txt");
        String Nombres = txtNombres.getText();
        String Apellidos = txtApellidos.getText();
        String Email = txtEmail.getText();
        String Perfil = txtPerfil.getText();
        MiembroJurado nuevo = new MiembroJurado(idJurado, Nombres, Apellidos, Email,Perfil);
        nuevo.saveFile("miembroJurado.txt");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Ha sido registrado Correctamente");
        a.show();
        txtNombres.clear();
        txtApellidos.clear();
        txtEmail.clear();
        txtPerfil.clear();      
                
    }
    
}
