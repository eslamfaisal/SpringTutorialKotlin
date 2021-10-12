package com.example.springbootvalidation;

import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "username cannot be empty 2")
    private String name;
    @NotBlank(message = "password cannot be empty")
    private String password;
    private Double grade;

    public User() {
    }

    public User(String name, String password, Double grade) {
        this.name = name;
        this.password = password;
        this.grade = grade;
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
