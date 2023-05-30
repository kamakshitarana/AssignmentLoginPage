package com.example.loginactivity.recllerView.model;

public class Character {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantoneValue;
    private int imgId; //this is static


    public Character(int id, String name, int year, String color, String pantoneValue) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantoneValue;
    }

    public Character(int imgId) {
        this.imgId = imgId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
