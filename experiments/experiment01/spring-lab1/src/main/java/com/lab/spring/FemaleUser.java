package com.lab.spring;

public class FemaleUser implements User {
    @Override
    public void pay() {
        System.out.println("FemaleUser is paying.");
    }

    @Override
    public void receive() {
        System.out.println("FemaleUser received money.");
    }
}