module com.pasaporte.SistemaPasaporte {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;

	opens com.pasaporte.vista to javafx.fxml;
	opens com.pasaporte.controlador to javafx.fxml;

	exports com.pasaporte.vista;
	exports com.pasaporte.controlador;

}
