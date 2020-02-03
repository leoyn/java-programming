package semester3.practice.database;

import oracle.jdbc.pool.OracleDataSource;
import semester3.practice.account.Account;
import semester3.practice.account.CheckingAccount;
import semester3.practice.account.Customer;
import semester3.practice.account.SavingsAccount;
import semester3.practice.account.Exceptions.AmountTooLowException;

import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {
    private String host;
    private String user;
    private String password;
    private Connection connection;

    public static void main(String[] args) throws SQLException {
        // Setup tables
        DatabaseConnection databaseConnection = new DatabaseConnection(args[0], args[1], args[2]);
        Connection connection = databaseConnection.connect();

        Statement statement = connection.createStatement();

        statement.executeUpdate("DROP TABLE account");
        statement.executeUpdate("DROP TABLE customer");

        statement.executeUpdate("CREATE TABLE customer (" + 
        "   customerId INT PRIMARY KEY," + 
        "   firstname VARCHAR(20)," + 
        "   lastname VARCHAR(20)," + 
        "   password VARCHAR(128)" + 
        ")");

        statement.executeUpdate("INSERT INTO customer (customerId, firstname, lastname, password) VALUES(1, 'Max', 'Musterman', '1234')");
        statement.executeUpdate("INSERT INTO customer (customerId, firstname, lastname, password) VALUES(2, 'Ahri', 'Musterman', 'secret')");

        statement.executeUpdate("CREATE TABLE account (" + 
        "   accountId INT PRIMARY KEY," + 
        "   type CHAR(1) NOT NULL," + 
        "   balance DECIMAL(18,2) NOT NULL," + 
        "   dispoLimit DECIMAL(18,2)," + 
        "   interest DECIMAL(18,2)," +
        "   customerId INT NOT NULL REFERENCES customer(customerId)" + 
        ")");

        statement.executeUpdate("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(1, 'C', 100, 1000, 1)");
        statement.executeUpdate("INSERT INTO account (accountId, type, balance, interest, customerId) VALUES(2, 'S', 2000, 1, 1)");

        statement.executeUpdate("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(3, 'C', 200, 200, 2)");
        statement.executeUpdate("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(4, 'C', 10, 0, 2)");
        
        databaseConnection.disconnect();
    }

    public DatabaseConnection(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public Connection connect() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL(host);
        connection = dataSource.getConnection(user, password);
        connection.setAutoCommit(false);
        return connection;
    }

    public Customer getCustomerById(int customerId) throws SQLException, SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT firstname, lastname FROM customer WHERE customerId = ?");
        statement.setInt(1, customerId);
        statement.execute();
        ResultSet result = statement.getResultSet();
        if(!result.next()) return null;
        connection.commit();
        return new Customer(customerId, result.getString("firstname"), result.getString("lastname"));
    }

    public void createCustomer(Customer customer) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer (customerId, firstname, lastname) VALUES(?, ?, ?)");
        statement.setInt(1, customer.getId());
        statement.setString(2, customer.getFirstname());
        statement.setString(3, customer.getLastname());
        
        statement.execute();
        connection.commit();
    }

    public void updateCustomer(Customer customer) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE customer SET firstname = ?, lastname = ? WHERE customerId = ?");
        statement.setString(1, customer.getFirstname());
        statement.setString(2, customer.getLastname());
        statement.setInt(3, customer.getId());

        statement.execute();
        connection.commit();
    }

    public ArrayList<Account> getAccountsForCustomer(Customer customer) throws SQLException, AmountTooLowException {
        ArrayList<Account> accountList = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement("SELECT accountId, type, balance, dispoLimit, interest FROM account WHERE customerId = ?");
        statement.setInt(1, customer.getId());
        statement.execute();
        ResultSet result = statement.getResultSet();

        while(result.next()) {
            Account account;
            switch(result.getString("type")) {
                case "C":
                    account = new SavingsAccount(customer, new BigDecimal(result.getInt("dispoLimit")));
                    break;
                case "S":
                    account = new CheckingAccount(customer, new BigDecimal(result.getInt("interest")));
                    break;
                default:
                    account = new Account(customer);
            }

            account.setBalance(new BigDecimal(result.getString("balance")));
            
            accountList.add(account);
        }

        return accountList;
    }

    public void disconnect() throws SQLException {
        connection.close();
        connection = null;
    }
}