package io.github.ledinhtri97.model;

import java.io.Serializable;

/**
 * Created by Anymo on 3/29/2017.
 */

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhome() {
        return phone;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setPhome(String phone) {
        this.phone = phone;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
