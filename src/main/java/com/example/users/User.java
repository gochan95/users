package com.example.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {
    private @Id @GeneratedValue Long uuid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    User(){}

    User (String username, String password){
        this.username = username;
        this.password = password;

    }

    public Long getUuid(){
        return this.uuid;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setUuid(Long uuid){
        this.uuid = uuid;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
