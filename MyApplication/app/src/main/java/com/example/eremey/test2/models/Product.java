package com.example.eremey.test2.models;

/**
 * Created by Eremey on 22.11.2016.
 */

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Product(int id, String name, int price, String description, int image) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Product(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
