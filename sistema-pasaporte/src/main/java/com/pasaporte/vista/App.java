package com.pasaporte.vista;

import com.pasaporte.controlador.PasaporteController;
import com.pasaporte.modelo.Pais;
import com.pasaporte.modelo.Pasaporte;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Collections;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        TextField txtId = new TextField();
        txtId.setPromptText("ID Pasaporte");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre Titular");

        TextField txtFecha = new TextField();
        txtFecha.setPromptText("Fecha de emisión");

        Button btnCrear = new Button("Crear Pasaporte");
        Label lblResultado = new Label();

        btnCrear.setOnAction(e -> {
            Pais pais = new Pais("COL", "Colombia", Collections.emptyList());
            PasaporteController controller = new PasaporteController();
            Pasaporte pasaporte = controller.crearPasaporte(
                txtId.getText(), txtNombre.getText(), txtFecha.getText(), pais
            );
            lblResultado.setText("Pasaporte creado: " + pasaporte);
        });

        VBox root = new VBox(10, txtId, txtNombre, txtFecha, btnCrear, lblResultado);
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Sistema de Pasaporte");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
