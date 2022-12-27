/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author prasa
 */
public class ExpenseModel {

 
  private String expenseName;
  private java.sql.Date expenseDate;
  private int expenseCost;
  
  
   public ExpenseModel(
    String expenseName,
    java.sql.Date expenseDate,
    int expenseCost
  ) {
    this.expenseName = expenseName;
    this.expenseDate = expenseDate;
    this.expenseCost = expenseCost;
  }

  

  public void setExpenseName(String expenseName) {
    this.expenseName = expenseName;
  }

  public void setExpenseDate(java.sql.Date expenseDate) {
    this.expenseDate = expenseDate;
  }

  public void setExpenseCost(int expenseCost) {
    this.expenseCost = expenseCost;
  }


  

  public String getExpenseName() {
    return expenseName;
  }

  public java.sql.Date getExpenseDate() {
    return expenseDate;
  }

  public int getExpenseCost() {
    return expenseCost;
  }

}
