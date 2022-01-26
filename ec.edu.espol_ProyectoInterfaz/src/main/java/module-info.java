module ec.edu.espol.proyecto_interfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto_interfaz to javafx.fxml;
    exports ec.edu.espol.proyecto_interfaz;
    opens ec.edu.espol.controller to javafx.fxml;
    exports ec.edu.espol.controller;
    opens ec.edu.espol.model to javafx.fxml;
    exports ec.edu.espol.model;
}
