package com.project.studentJPAday5.DTO;

public class StudentResponseDTO{
    private int id;
    private String name;
    private String email;

    public StudentResponseDTO(){};

    public StudentResponseDTO(int id,String name,String email){
        this.name=name;
        this.id=id;
        this.email=email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
