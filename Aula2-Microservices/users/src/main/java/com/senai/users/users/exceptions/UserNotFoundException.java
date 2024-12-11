package com.senai.users.users.exceptions;

public class UserNotFoundException extends UsersExeption {
    public UserNotFoundException() {
        super("User not found", "USER-NOT-FOUND");
    }

    public UserNotFoundException(String message, String code) {
        super(message, code);
    }
}
