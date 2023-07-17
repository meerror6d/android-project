package com.example.gadgetstore;

public class scrollmodel {
    private int productimage;
    private String producttitle;
    private String productdescription;
    private String productprize;


    public scrollmodel(int productimage, String producttitle, String productdescription, String productprize) {
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprize = productprize;
    }


    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductprize() {
        return productprize;
    }

    public void setProductprize(String productprize) {
        this.productprize = productprize;
    }
}
