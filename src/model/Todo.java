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
public Todo(String text){
    this.text=text;
}

public void setText(String text){
    
    this.text=text;
}

public String getText(){
    return text;
}
    
}
