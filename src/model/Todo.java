/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aasis
 */
public class Todo {
private String text;
private String status_str;

public Todo(String text,String status_str){
    this.text=text;
    this.status_str=status_str;
}

public void setText(String text){
    
    this.text=text;
}

public String getText(){
    return text;
}
public void setStatus(String status_str){
    this.status_str=status_str;
}
public String getStatus(){
    return status_str;
}
}
