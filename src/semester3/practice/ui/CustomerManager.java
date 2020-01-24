package semester3.practice.ui;

import semester3.practice.database.DatabaseConnection;

import javafx.application.*;
import javafx.stage.*;
import javafx.fxml.*;
import javafx.scene.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class CustomerManager extends Application {
	private DatabaseConnection databaseConnection;
	private static String[] ARGS;
	public static void main(String[] args) {
		ARGS = args;
		Application.launch(CustomerManager.class);
	}
	
	public void init() throws SQLException {
		databaseConnection = new DatabaseConnection(ARGS[0], ARGS[1], ARGS[2]);
		databaseConnection.connect();
	}

	public void start(Stage stage) throws IOException {
		// load fxml
		final URL fxmlFilePath = getClass().getResource("assets/CustomerView.fxml"); 
		final FXMLLoader loader = new FXMLLoader(fxmlFilePath);
		loader.setController(new CustomerManagerController(databaseConnection)); // has to be before loader.load() otherwise it won't work
		final Parent root = loader.load();
		
		// create window
		Scene scene = new Scene(root, 400, 300);
		stage.setTitle("Customer Manager");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}