package com.model;

public class Country {
    private int numeric;
    private String alpha2;
    private String name;
    private String emoji;
    private String currency;
    private double latitude;
    private double longitude;


    @Override
    public String toString() {
        return "Country [numeric=" + numeric + ", alpha2=" + alpha2 + ", name=" + name + ", emoji=" + emoji
                + ", currency=" + currency + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    public int getNumeric() {
        return numeric;
    }

    public void setNumeric(int numeric) {
        this.numeric = numeric;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


}
