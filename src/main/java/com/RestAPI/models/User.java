package com.RestAPI.models;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

@Component
@Table("user")
public class User {
    @PrimaryKey
    private int id;

    private String name;

    private String address;

    private int age;

    @Transient
    private String action;

    public User(){}

    public User(int id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setAction(String action1){
        this.action=action1;
    }
    public String getAction(){
        return action;
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append('}').append(getAction()).append(' ');
        return sb.toString();
    }



}
