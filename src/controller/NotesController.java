/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import database.DbConnection;
import java.sql.ResultSet;
import model.Notes;
/**
 *
 * @author Dell
 */
public class NotesController {
    
    DbConnection dbConnection;

    public int insertNote(Notes note){
        String myNote = note.getText();
        String insertQuery = String.format(
      "INSERT INTO notes_data(note) VALUES('%s')",
      myNote
    );
        dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
    }
    
    public ResultSet getNotes(){
      dbConnection = new DbConnection();
    String selectQuery = String.format(
      "select * from notes_data"
    );
    ResultSet result = dbConnection.retrieve(selectQuery);
    return result;
  }
}
