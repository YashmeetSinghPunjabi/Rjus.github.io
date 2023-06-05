package com.elearning.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Admin {
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    int admin_id;

    @Column
    @NotNull
    String password;

    @Column
    @NotNull
    String username;

}
