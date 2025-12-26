package com.project.studentJPAday5.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {


   @NotBlank(message = "Name is Required")
   private String name;

   @Email(message = "Email should be in the correct format")
   @NotBlank(message = "Email is required")
   private String email;

   @NotBlank(message = "Password is required")
   @Size(min=6,message = "Password must be atleast 6 Characters")
   private String password;

   public StudentRequestDTO(){};

   public StudentRequestDTO(String name,String email, String password){
       this.name=name;
       this.email=email;
       this.password=password;
   }

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPassword() {
      return password;
   }
}
