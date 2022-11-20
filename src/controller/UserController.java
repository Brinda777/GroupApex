package controller;

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


  
}
