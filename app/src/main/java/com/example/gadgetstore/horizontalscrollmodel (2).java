package com.example.gadgetstore;

import kotlin.jvm.internal.PropertyReference0Impl;

public class horizontalscrollmodel {

    private String productid;
    int productimage;
    private String producttitle;
    private String productdescription;
    private String productprice;


    public horizontalscrollmodel(int productimage, String producttitle, String productdescription, String productprice) {

        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprice = productprice;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
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
}
