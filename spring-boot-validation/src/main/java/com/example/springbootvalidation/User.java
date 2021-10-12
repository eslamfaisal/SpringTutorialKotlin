package com.example.springbootvalidation;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "username cannot be empty 2")
    private String name;

    @Email(message = "fuck you")
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Length(min = 0, max = 10, message = "تبا لك")
    private String password;

    @Max(value = 10, message = "max chars is 10")
    @Min(value = 0, message = "min chars is 0")
    private Double grade;

    public User() {
    }

    public User(String name, String email, String password, Double grade) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }
}
