package com.model;

public class Number {

    private String luhn;
    private int length;


    public String getLuhn() {
        return luhn;
    }

    public void setLuhn(String luhn) {
        this.luhn = luhn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Number [luhn=" + luhn + ", length=" + length + "]";
    }


}
