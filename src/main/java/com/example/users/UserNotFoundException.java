package com.example.users;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long uuid) {
        super("Could not find user " + uuid);
      }
    //exception for finding username for login
    UserNotFoundException(String username){
        super("Could not find user " + username + "or password is incorrect");
    }
}
