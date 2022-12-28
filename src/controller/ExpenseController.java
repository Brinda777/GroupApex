package controller;

import database.DbConnection;
import java.sql.*;
import model.ExpenseModel;
import model.User;

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
      "INSERT INTO expenses_data(expense_name,expense_amount,expense_date,uid) VALUES( '%s', '%s','%s',%d)",
      expenseName,
      expenseAmount,
      expenseDate,
      User.id
    );

    dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
  }
  
  public ResultSet getExpenses(String item){
      dbConnection = new DbConnection();
      if(item.equals("All")){
          String selectQuery = String.format(
      "select * from expenses_data WHERE uid=%d",User.id
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
  
  public double getTotalValue(){
      dbConnection = new DbConnection();
      String getQuery = String.format("SELECT SUM(expense_amount) FROM expenses_data WHERE uid = %d",User.id);
      ResultSet rs = dbConnection.retrieve(getQuery);
      try{
          if(rs.next()){
              double total = rs.getDouble(1);
              return total;
          }
      }catch(SQLException e){
          e.printStackTrace();
      }
      return 0;
  }
}
