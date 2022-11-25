package controller;
import java.sql.*;

import database.DbConnection;
import model.User;

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
      "INSERT INTO users_data VALUES('%s', '%s', %d, '%s', '%s', '%s','%s')",
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
  public User forgotPassword(String phoneNumber,String favFood ){
      dbConnection=new DbConnection();
      String selectQuery=String.format("select * from users_data where phone_number='%s' and favourite_food='%s'", phoneNumber,favFood);
      System.out.println(selectQuery);
      ResultSet result=dbConnection.retrieve(selectQuery);
      try {
          while (result.next()){
              String fName=result.getString("first_name");
              String fFood=result.getString("favourite_food");
              String email=result.getString("email");
              String password=result.getString("pass");
              User retrieve_user=new User(fName,null,0,null,email,password,fFood);
//          System.out.println(result.getString("first_name"));
          return  retrieve_user;
          }
          
      } catch(SQLException e){
      e.printStackTrace();}
      return null;
      
      
  }
  
  


  
}
