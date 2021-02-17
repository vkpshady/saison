package com.model;

public class CardInformation {


    private Number number;
    private Country country;
    private Bank bank;
    private String scheme;
    private String type;
    private String brand;
    private boolean prepaid;


    @Override
    public String toString() {
        return "CardInformation [number=" + number.toString() + ", country=" + country.toString() + ", bank=" + bank.toString() + ", scheme=" + scheme
                + ", type=" + type + ", brand=" + brand + ", prepaid=" + prepaid + "]";
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }


}
