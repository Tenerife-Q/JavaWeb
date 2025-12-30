package org.example;

import org.springframework.stereotype.Component;

/**
 * @ClassName : Person
 * @Description :
 * @Author : ZJ
 * @Date: 2025-11-12 16:37
 */

public class Person implements Thinkable {
    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    String personname;

    @Override
    public void thinking() {

        System.out.println(personname+"Thinking Person");
    }
}
