package com.example.yccollage.ebook;

public class EbookData
{
    private String title,Durl,key,Sfilename;

    public EbookData()
    {
    }

    public EbookData(String title, String durl, String sfilename,String key) {
        this.title = title;
        this.Durl = durl;
        this.Sfilename = sfilename;
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDurl() {
        return Durl;
    }

    public void setDurl(String durl) {
        Durl = durl;
    }

    public String getSfilename() {
        return Sfilename;
    }

    public void setSfilename(String sfilename) {
        Sfilename = sfilename;
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }
}
