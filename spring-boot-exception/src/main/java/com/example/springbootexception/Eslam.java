package com.example.springbootexception;

public class Eslam {

    String eslam;

    public Eslam() {
        System.out.println("create eslam objetc");
    }

    public Eslam(String eslam) {
        this.eslam = eslam;
    }

    public String getEslam() {
        return "eslam";
    }

    public void setEslam(String eslam) {
        this.eslam = eslam;
    }
}
