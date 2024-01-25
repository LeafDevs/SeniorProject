package me.leaf.devs.entities;

public class Skin {

    public Skin(String name, String texture, String signiture) {
        this.name = name;
        this.texture = texture;
        this.signiture = signiture;
    }

    private String name, texture, signiture;
    

    public String getName() {
        return this.name;
    }

    public String getTexture() {
        return this.texture;
    }
    public String getSigniture() {
        return this.signiture;
    }

}
