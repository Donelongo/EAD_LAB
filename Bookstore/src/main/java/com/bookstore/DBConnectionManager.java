//Dagmawi Elias Lewi

package com.bookstore;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
public class DBConnectionManager {
    private String jdbcURL = "jdbc:mysql://localhost:3306/BookstoreDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";
    private Connection connection;

    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
