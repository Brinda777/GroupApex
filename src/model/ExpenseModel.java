/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author prasa
 */
public class ExpenseModel {

 
  private String expenseName;
  private String expenseDate;
  private int expenseCost;
  
  
   public ExpenseModel(
    String expenseName,
    String expenseDate,
    int expenseCost
  ) {
    this.expenseName = expenseName;
    this.expenseDate = expenseDate;
    this.expenseCost = expenseCost;
  }

  

  public void setExpenseName(String expenseName) {
    this.expenseName = expenseName;
  }

  public void setExpenseDate(String expenseDate) {
    this.expenseDate = expenseDate;
  }

  public void setExpenseCost(int expenseCost) {
    this.expenseCost = expenseCost;
  }


  

  public String getExpenseName() {
    return expenseName;
  }

  public String getExpenseDate() {
    return expenseDate;
  }

  public int getExpenseCost() {
    return expenseCost;
  }

}
