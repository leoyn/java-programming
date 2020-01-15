package semester3.practice.database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

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

        statement.executeQuery("CREATE TABLE customer (" + 
        "   customerId INT PRIMARY KEY," + 
        "   firstname VARCHAR(20)," + 
        "   lastname VARCHAR(20)," + 
        "   password VARCHAR(128)" + 
        ")");

        statement.executeQuery("INSERT INTO customer (customerId, firstname, lastname, password) VALUES(1, 'Max', 'Musterman', '1234')");
        statement.executeQuery("INSERT INTO customer (customerId, firstname, lastname, password) VALUES(2, 'Ahri', 'Musterman', 'secret')");

        statement.executeQuery("CREATE TABLE account (" + 
        "   accountId INT PRIMARY KEY," + 
        "   type CHAR(1) NOT NULL," + 
        "   balance DECIMAL(18,2) NOT NULL," + 
        "   dispoLimit DECIMAL(18,2)," + 
        "   customerId INT NOT NULL REFERENCES customer(customerId)" + 
        ")");

        statement.executeQuery("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(1, 'C', 100, 1000, 1)");
        statement.executeQuery("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(2, 'S', 2000, NULL, 1)");

        statement.executeQuery("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(3, 'C', 200, 200, 2)");
        statement.executeQuery("INSERT INTO account (accountId, type, balance, dispoLimit, customerId) VALUES(4, 'C', 10, 0, 2)");
        
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
        return connection;
    }

    public void disconnect() throws SQLException {
        connection.close();
        connection = null;
    }
}