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

    public Students(){};

    public Students(String name,String email){
        this.name=name;
        this.email=email;
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
}
