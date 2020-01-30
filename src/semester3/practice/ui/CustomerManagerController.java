package semester3.practice.ui;

import semester3.practice.account.Account;
import semester3.practice.account.Customer;
import semester3.practice.account.SavingsAccount;
import semester3.practice.account.Exceptions.AmountTooLowException;
import semester3.practice.database.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class CustomerManagerController {
    private DatabaseConnection databaseConnection;
    @FXML private Button loadBtn;
    @FXML private Button saveBtn;
    @FXML private Button createBtn;
    @FXML private TextField customerIdTextField;
    @FXML private TextField customerFirstnameTextField;
    @FXML private TextField customerLastnameTextField;
    @FXML private ListView<String> accountList;
    @FXML private Label errorLbl;
    @FXML private Label successLbl;
    @FXML private Label accountListLbl;

    public CustomerManagerController(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void initialize() {
        accountListLbl.textProperty().bind(customerFirstnameTextField.textProperty());

        loadBtn.addEventHandler(ActionEvent.ACTION, new myButtonHandler()::myHandle);
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

        saveBtn.addEventHandler(ActionEvent.ACTION, evt -> { // method reference as lambda function
            successLbl.setText("");
            try {
                databaseConnection.updateCustomer(new Customer(Integer.parseInt(customerIdTextField.getText()), customerFirstnameTextField.getText(), customerLastnameTextField.getText()));
                errorLbl.setText("");
                successLbl.setText("Customer was saved.");
            } catch(SQLException err) {
                errorLbl.setText("Something went wrong.");
            }
        });

        customerIdTextField.addEventHandler(ActionEvent.ACTION, new myButtonHandler()::myHandle); // method reference
    }

    class myButtonHandler {
        public void myHandle(ActionEvent evt) {
            successLbl.setText("");
            errorLbl.setText("");

            try {
                int customerId = Integer.parseInt(customerIdTextField.getText());
                Customer customer = databaseConnection.getCustomerById(customerId);

                if(customer == null) {
                    errorLbl.setText("Customer with that ID does not exist.");
                } else {
                    customerFirstnameTextField.setText(customer.getFirstname());
                    customerLastnameTextField.setText(customer.getLastname());

                    ArrayList<Account> accounts = databaseConnection.getAccountsForCustomer(customer);

                    ObservableList<String> data = FXCollections.observableArrayList();
                    accounts.forEach(account->{
                        String type = account.getClass() == SavingsAccount.class ? "Savings" : "Checking";
                        data.add(type + " - " + account.getBalance() + "€");
                    });

                    accountList.setItems(data);

                    if(!loadBtn.isFocused()) customerFirstnameTextField.requestFocus();
                }
            } catch(SQLException err) {
                errorLbl.setText("Something went wrong.");
            } catch(NumberFormatException err) {
                errorLbl.setText("Customer ID must not include non-numberic characters.");
            } catch(AmountTooLowException err) {
                //TODO: Handle error
            }
        }
    }
}