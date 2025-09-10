package com.pasaporte.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControladorFormulario {

	@FXML
	private Button btCreate;

	@FXML
	private Button btDelete;

	@FXML
	private Button btRead;

	@FXML
	private Button btUpdate;

	@FXML
	private ComboBox<String> combo;
	
	 @FXML
	    public void initialize() {
	        // Aquí agregamos las opciones al ComboBox
	        combo.getItems().addAll("Diplomático", "Ordinario");
	    }

	@FXML
	private TextField txt1;

	@FXML
	private TextField txt2;

	@FXML
	void actionCreate(ActionEvent event) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Guardado con Éxito");
		a.show();

	}

	@FXML
	void actionDelete(ActionEvent event) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Borrado con Éxito");
		a.show();

	}

	@FXML
	void actionRead(ActionEvent event) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Leido con Éxito");
		a.show();

	}

	@FXML
	void actionUpdate(ActionEvent event) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Actualizado con Éxito");
		a.show();

	}

}
