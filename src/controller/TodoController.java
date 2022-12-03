/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DbConnection;
import model.Todo;

/**
 *
 * @author aasis
 */
public class TodoController {
    DbConnection dbConnection;
    public int insertTodo(Todo todo){
        String myStatus=todo.getStatus();
        String myTodo = todo.getText();
        String insertQuery = String.format( "INSERT INTO todo_data(todo,status_text) VALUES('%s','%s')", myTodo,myStatus);
//        insertQuery.setString(1,myTodo);
//        insertQuery.setString(2,myStatus);
        
        dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
    }
    public int findTodo(Todo todo) {
        String findQuery=String.format("select * from todo_data");
        System.out.println(findQuery);
        dbConnection= new DbConnection();
        int result = dbConnection.manipulate(findQuery);
    return result;
    }
}
