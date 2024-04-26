package com.arbahi.examsmanagement.Exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User not found");
    }
}
