package controller;

import database.DbConnection;
import model.ExpenseModel;

public class ExpenseController {

  // database connection
  DbConnection dbConnection;

  public int insertExpense(ExpenseModel expenseModel) {
    // getting expense info

    String expenseName = expenseModel.getExpenseName();
    String expenseAmount = expenseModel.getExpenseCost();
    String expenseDate = expenseModel.getExpenseDate();

    // code to add user
    String insertQuery = String.format(
      "INSERT INTO expenses_date VALUES( '%s', '%s','%s')",
      expenseName,
      expenseAmount,
      expenseDate
    );

    dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
  }
}
