package com.example.fredd.myparcial.entities;

import com.orm.SugarRecord;

public class Users extends SugarRecord<Users> {
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public  String user;

    public Users() {
    }
}
