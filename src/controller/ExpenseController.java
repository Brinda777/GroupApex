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
    int expenseAmount = expenseModel.getExpenseCost();
    java.sql.Date expenseDate = expenseModel.getExpenseDate();

    // code to add user
    String insertQuery = String.format(
      "INSERT INTO expenses_data(expense_name,expense_amount,expense_date) VALUES( '%s', '%s','%s')",
      expenseName,
      expenseAmount,
      expenseDate
    );

    dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
  }
  
  public ResultSet getExpenses(String item){
      dbConnection = new DbConnection();
      if(item.equals("All")){
          String selectQuery = String.format(
      "select * from expenses_data"
    );
          ResultSet result = dbConnection.retrieve(selectQuery);
        return result;
      }else{
          String selectQuery = String.format
        ("select * from expenses_data WHERE monthname(expense_date) = '%s'",item);
          ResultSet result = dbConnection.retrieve(selectQuery);
        return result;
      }
    
    
  }
}
