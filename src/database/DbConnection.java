package database;

import java.sql.*;
import javax.swing.*;

public class DbConnection {

  public Connection connection;

  Statement statement;

  ResultSet resultSet;

  int value;

  public DbConnection() {
    try {
      String username = "sql6582488";

      String password = "4yqrLf897c";

      Class.forName("com.mysql.cj.jdbc.Driver");

      connection =
        DriverManager.getConnection(
          "jdbc:mysql://sql6.freesqldatabase.com/sql6582488",
          username,
          password
        );

      if (connection != null) {
        System.out.println("Connected to database");
      } else {
        System.out.println("Error connecting to database");
      }

      statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Via the use of sql query

  // insert, update and delete

  public int manipulate(String query) {
    try {
      value = statement.executeUpdate(query);

      connection.close();
    } catch (SQLIntegrityConstraintViolationException ex) {
      JOptionPane.showMessageDialog(null, "These details already exist!");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return value;
  }

  public ResultSet retrieve(String query) {
    try {
      resultSet = statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return resultSet;
  }

  public static void main(String[] args) {
    new DbConnection();
  }
}
