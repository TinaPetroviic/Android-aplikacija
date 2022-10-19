package com.example.flowers;

public class Plants {
    private final int image;
    private final String name;
    private final String description;
    private final int id;

    public Plants(String name, int image,String description, int id) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public int getImage() {return image;}

    public String getDescription () {return description;}

    public int getId () {return id;}

}