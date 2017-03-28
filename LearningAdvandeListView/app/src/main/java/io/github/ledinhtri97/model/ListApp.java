package io.github.ledinhtri97.model;

import java.io.Serializable;

/**
 * Created by Anymo on 3/23/2017.
 */

public class ListApp implements Serializable{
    private String info;
    private String phone;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ListApp() {

    }

    public ListApp(String info, String phone) {

        this.info = info;
        this.phone = phone;
    }
}
