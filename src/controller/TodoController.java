/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DbConnection;
import java.sql.ResultSet;
import model.Todo;
import model.User;

/**
 *
 * @author aasis
 */
public class TodoController {
    DbConnection dbConnection;
    public int insertTodo(Todo todo){
        String myStatus=todo.getStatus();
        String myTodo = todo.getText();
        String insertQuery = String.format( "INSERT INTO todo_data(todo,status_text,uid) VALUES('%s','%s',%d)", myTodo,myStatus,User.id);
//        insertQuery.setString(1,myTodo);
//        insertQuery.setString(2,myStatus);
        
        dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
    }
    
    public ResultSet getTodo(){
      dbConnection = new DbConnection();
    String selectQuery = String.format(
      "select * from todo_data where uid = %d",User.id
    );
    ResultSet result = dbConnection.retrieve(selectQuery);
    return result;
  }
    
}
