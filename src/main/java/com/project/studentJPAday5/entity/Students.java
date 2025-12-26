package com.project.studentJPAday5.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    private String email;

    private String password;

    public Students(){};

    public Students(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public int getId() {
        return Id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
