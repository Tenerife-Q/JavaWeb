package com.lab.spring;

public class MaleUser implements User {
    @Override
    public void pay() {
        System.out.println("MaleUser is paying.");
    }

    @Override
    public void receive() {
        System.out.println("MaleUser received money.");
    }
}