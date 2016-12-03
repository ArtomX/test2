package com.example.eremey.test2.models;

/**
 * Created by Eremey on 25.11.2016.
 */

public class Wall {
    private String image;
    private String name;

    public Wall(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
