package com.utag.phase1.domain;

/**
 * 整张图片标注的持久类
 */

import java.io.Serializable;

public class TagWhole implements Serializable {

    /**
     *照片id
     */
    private String imageID;

    /**
     *标注描述
     */
    private String description;


    public TagWhole() {
    }


    public TagWhole(String imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
