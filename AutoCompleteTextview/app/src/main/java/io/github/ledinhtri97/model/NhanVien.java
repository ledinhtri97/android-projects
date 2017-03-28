package io.github.ledinhtri97.model;

/**
 * Created by Anymo on 3/23/2017.
 */

public class NhanVien {
    private String name;
    private String thu;

    public NhanVien() {
    }

    public NhanVien(String name, String thu) {

        this.name = name;
        this.thu = thu;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    @Override
    public String toString() {
        return this.name + " bat dau cong tac thu " + this.thu;
    }
}
