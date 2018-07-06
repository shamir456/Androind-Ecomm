package com.example.shameer.mysqlw.Model;

public class Customers {

    private String name,password;

    public Customers(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Customers() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
