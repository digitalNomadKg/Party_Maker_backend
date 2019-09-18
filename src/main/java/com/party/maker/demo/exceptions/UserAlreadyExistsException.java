package com.party.maker.demo.exceptions;

public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
