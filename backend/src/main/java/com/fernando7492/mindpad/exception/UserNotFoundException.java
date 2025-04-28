package com.fernando7492.mindpad.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User Not Found");
    }
}
