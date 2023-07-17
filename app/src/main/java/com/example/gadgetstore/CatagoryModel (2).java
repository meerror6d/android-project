package com.example.gadgetstore;

public class CatagoryModel {
    private String Catagoryiconlink;
    private String catagoryname;

    public CatagoryModel(String catagoryiconlink, String catagoryname) {
        Catagoryiconlink = catagoryiconlink;
        this.catagoryname = catagoryname;
    }

    public String getCatagoryiconlink() {
        return Catagoryiconlink;
    }

    public void setCatagoryiconlink(String catagoryiconlink) {
        Catagoryiconlink = catagoryiconlink;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname;
    }
}
