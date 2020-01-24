package semester3.practice.ui;

import semester3.practice.account.Customer;
import semester3.practice.database.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.*;

import java.sql.SQLException;

public class CustomerManagerController {
    private DatabaseConnection databaseConnection;
    @FXML private Button loadBtn;
    @FXML private Button saveBtn;
    @FXML private Button createBtn;
    @FXML private TextField customerIdTextField;
    @FXML private TextField customerFirstnameTextField;
    @FXML private TextField customerLastnameTextField;
    @FXML private TextArea commentArea;
    @FXML private Label errorLbl;
    @FXML private Label successLbl;

    public CustomerManagerController(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void initialize() {
       loadBtn.addEventHandler(ActionEvent.ACTION, new myButtonHandler());
       createBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
                successLbl.setText("");
                try {
                    databaseConnection.createCustomer(new Customer(Integer.parseInt(customerIdTextField.getText()), customerFirstnameTextField.getText(), customerLastnameTextField.getText()));
                    errorLbl.setText("");
                    successLbl.setText("Customer was created.");
                } catch(SQLException err) {
                    errorLbl.setText("Customer with that ID already exists.");
                } catch(NumberFormatException err) {
                    errorLbl.setText("Customer ID must not include non-numberic characters.");
                }
            }
        });

        saveBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
                successLbl.setText("");
                try {
                    databaseConnection.updateCustomer(new Customer(Integer.parseInt(customerIdTextField.getText()), customerFirstnameTextField.getText(), customerLastnameTextField.getText()));
                    errorLbl.setText("");
                    successLbl.setText("Customer was saved.");
                } catch(SQLException err) {
                    errorLbl.setText("Something went wrong.");
                }
            }
        });
    }

    class myButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent evt) {
            successLbl.setText("");
            try {
                int customerId = Integer.parseInt(customerIdTextField.getText());
                Customer customer = databaseConnection.getCustomerById(customerId);

                if(customer == null) {
                    errorLbl.setText("Customer with that ID does not exist.");
                } else {
                    customerFirstnameTextField.setText(customer.getFirstname());
                    customerLastnameTextField.setText(customer.getLastname());
                }
            } catch(SQLException err) {
                errorLbl.setText("Something went wrong.");
            } catch(NumberFormatException err) {
                errorLbl.setText("Customer ID must not include non-numberic characters.");
            }
        }
    }
}