package com.party.maker.demo.exceptions;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException (String message){
        super (message);
    }
}
