package com.utag.phase1.domain;

import java.io.Serializable;

public class TagWhole implements Serializable {

    /**
     *
     */
    private int imageID;

    /**
     *
     */
    private String description;


    public TagWhole() {
    }


    public TagWhole(int imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
