package io.github.ledinhtri97.model;

import java.io.Serializable;

/**
 * Created by Anymo on 3/29/2017.
 */

public class Sms implements Serializable {
    private String sms;

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Sms(String sms) {

        this.sms = sms;
    }
}
