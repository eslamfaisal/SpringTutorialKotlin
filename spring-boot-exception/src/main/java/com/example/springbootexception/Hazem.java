package com.example.springbootexception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hazem {

    private Eslam user;

    String hazem;

    public Hazem() {
        System.out.println("create Hazem objetc");
    }

    public Hazem(String eslam) {
        this.hazem = eslam;
    }

    @Autowired
    public Hazem(Eslam user) {
        this.user = user;
    }


    public String getHazem() {
        return user.getEslam();
    }

    public void setHazem(String hazem) {
        this.hazem = hazem;
    }
}
