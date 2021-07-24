package com.example.yccollage.ui.about;

public class CourceModel {
    private int img;
    private String title,dicri;

    public CourceModel(int img, String title, String dicri) {
        this.img = img;
        this.title = title;
        this.dicri = dicri;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDicri() {
        return dicri;
    }

    public void setDicri(String dicri) {
        this.dicri = dicri;
    }
}
