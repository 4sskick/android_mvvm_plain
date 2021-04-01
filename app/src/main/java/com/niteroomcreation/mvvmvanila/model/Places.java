package com.niteroomcreation.mvvmvanila.model;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class Places {

    private String imgUrl;
    private String name;

    public Places( String name) {
        this.imgUrl = "";
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Places{" +
                "imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
