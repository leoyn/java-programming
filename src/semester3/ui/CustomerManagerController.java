package semester3.ui;

import semester3.account.Account;
import semester3.account.CheckingAccount;
import semester3.account.Customer;
import semester3.account.SavingsAccount;
import semester3.account.Exceptions.AmountTooLowException;
import semester3.database.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

import java.sql.SQLException;
import java.util.ArrayList;

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
        customerFirstnameTextField.textProperty().addListener((value, oldValue, newValue) -> {
            accountListLbl.setText(newValue + " accounts:");
        });

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
                        String output;

                        if(account.getClass() == SavingsAccount.class) {
                            output = "Savings";
                            output += " - ";
                            output += "Interest: " + ((SavingsAccount) account).getInterest() + "%";
                        } else if(account.getClass() == CheckingAccount.class) {
                            output = "Checking";
                            output += " - ";
                            output += "Dispo-Limit: " + ((CheckingAccount) account).getDispoLimit() + "€";
                        } else {
                            output = "Other";
                        }

                        output += " - Balance: " + account.getBalance() + "€";

                        data.add(output);
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