package com.senai.users.users.exceptions;

public class UsersExeption extends Exception{
    private final String code;

    public UsersExeption(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
