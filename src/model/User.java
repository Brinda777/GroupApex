/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author prasa
 */
public class User {

  private int age=0;
  private String firstName=null;
  private String lastName=null;
  private String phoneNumber=null;
  private String email=null;
  private String password=null;
  private String favouriteFood=null;
  public static int id;
   public User(
    String firstName,
    String lastName,
    int age,
    String phoneNumber,
    String email,
    String password,
    String favouriteFood
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.favouriteFood = favouriteFood;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFavouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
  }
  
 

  public int getAge() {
    return age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFavouriteFood() {
    return favouriteFood;
  }
}
