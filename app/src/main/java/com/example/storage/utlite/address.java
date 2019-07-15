package com.example.storage.utlite;

public class address {
    int id;
    String name, data;

    public address() {

    }

    public address(Integer id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getdata() {
        return data;
    }
}
