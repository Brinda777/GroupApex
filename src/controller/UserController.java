package controller;

import database.DbConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import model.User;
import view.LoginPage;

public class UserController {

  // database connection
  DbConnection dbConnection;

  public int insertUser(User user) {
    // getting user info

    int userAge = user.getAge();
    String userFirstName = user.getFirstName();
    String userLastName = user.getLastName();
    String userPhoneNumber = user.getPhoneNumber();
    String userEmail = user.getEmail();
    String userPassword = user.getPassword();
    String userFavouriteFood = user.getFavouriteFood();

    // code to add user
    String insertQuery = String.format(
      "INSERT INTO users_data(first_name,last_name,age,phone_number,email,pass,favourite_food) VALUES('%s', '%s', %d, '%s', '%s', '%s','%s')",
      userFirstName,
      userLastName,
      userAge,
      userPhoneNumber,
      userEmail,
      userPassword,
      userFavouriteFood
    );

    dbConnection = new DbConnection();

    int result = dbConnection.manipulate(insertQuery);
    return result;
  }
  
  public void changePassword(String pNum,String oldPass,String newPass){
      dbConnection = new DbConnection();
      String selectQuery = String.format("Select * from users_data where phone_number = '%s'",pNum);
      ResultSet result = dbConnection.retrieve(selectQuery);
      
      
      try{
          while(result.next()){
              String prevPass = result.getString("pass");
              if(prevPass.equals(oldPass)){
                  String updateQuery = String.format("update users_data set pass='%s' where phone_number='%s'",
              newPass,
              pNum);
                  dbConnection.manipulate(updateQuery);
              }
          }
      }catch(SQLException e){
          e.printStackTrace();
      }
      
  }

  public User forgotPassword(String phoneNumber, String favFood, String pw) {
    dbConnection = new DbConnection();
    String selectQuery = String.format(
      "select * from users_data where phone_number='%s' and favourite_food='%s'",
      phoneNumber,
      favFood
    );
    String updateQuery = String.format(
      "update users_data set pass='%s' where phone_number='%s'",
      pw,
      phoneNumber
    );
    System.out.println(selectQuery);
    ResultSet result = dbConnection.retrieve(selectQuery);

    int newResult = dbConnection.manipulate(updateQuery);
    try {
      while (result.next()) {
        String fName = result.getString("first_name");
        String fFood = result.getString("favourite_food");
        String email = result.getString("email");
        String password = result.getString("pass");
        User retrieve_user = new User(
          fName,
          null,
          0,
          null,
          email,
          password,
          fFood
        );
        //          System.out.println(result.getString("first_name"));
        return retrieve_user;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public User loginPage(String pnum, String pas) {
    dbConnection = new DbConnection();
    String selectQuery = String.format("select phone_number,pass,id from users_data where phone_number='%s'",pnum);
    System.out.println(selectQuery);
    ResultSet result = dbConnection.retrieve(selectQuery);
    try {
      while (result.next()) {
        String DbPnum = result.getString("phone_number");
        String Dbpass = result.getString("pass");
        int cUId = result.getInt("id");
        System.out.println(cUId);
        User.id = cUId;


        User retriver_user = new User(
          null,
          null,
          0,
          DbPnum,
          null,
          Dbpass,
          null
        );

        return retriver_user;
        
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
}
