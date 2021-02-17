package com.model;

public class Bank {

    private String name;
    private String url;
    private String phone;
    private String city;


    @Override
    public String toString() {
        return "Bank [name=" + name + ", url=" + url + ", phone=" + phone + ", city=" + city + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
