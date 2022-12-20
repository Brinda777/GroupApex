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
  private Date expenseDate;
  private String expenseCost;
  
  
   public ExpenseModel(
    String expenseName,
    Date expenseDate,
    String expenseCost
  ) {
    this.expenseName = expenseName;
    this.expenseDate = expenseDate;
    this.expenseCost = expenseCost;
  }

  

  public void setExpenseName(String expenseName) {
    this.expenseName = expenseName;
  }

  public void setExpenseDate(Date expenseDate) {
    this.expenseDate = expenseDate;
  }

  public void setExpenseCost(String expenseCost) {
    this.expenseCost = expenseCost;
  }


  

  public String getExpenseName() {
    return expenseName;
  }

  public Date getExpenseDate() {
    return expenseDate;
  }

  public String getExpenseCost() {
    return expenseCost;
  }

}
