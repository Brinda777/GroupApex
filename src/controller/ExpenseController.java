package controller;

import database.DbConnection;
import java.sql.*;
import model.ExpenseModel;

public class ExpenseController {

  // database connection
  DbConnection dbConnection;

  public int insertExpense(ExpenseModel expenseModel) {
    // getting expense info

    String expenseName = expenseModel.getExpenseName();
    String expenseAmount = expenseModel.getExpenseCost();
    Date expenseDate = (Date) expenseModel.getExpenseDate();

    // code to add user
    String insertQuery = String.format(
      "INSERT INTO expenses_data VALUES( '%s', '%s','%s')",
      expenseName,
      expenseAmount,
      expenseDate
    );

    dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
  }
  
  public ResultSet getExpenses(){
      dbConnection = new DbConnection();
    String selectQuery = String.format(
      "select * from expenses_data"
    );
    ResultSet result = dbConnection.retrieve(selectQuery);
    return result;
  }
}
