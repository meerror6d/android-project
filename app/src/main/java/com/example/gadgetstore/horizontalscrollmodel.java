package com.example.gadgetstore;

import kotlin.jvm.internal.PropertyReference0Impl;

public class horizontalscrollmodel {

    private String productid;
    private String productimage;
    private String producttitle;
    private String productdescription;
    private String productprice;


    public horizontalscrollmodel(String productid,String productimage, String producttitle, String productdescription, String productprice) {

        this.productid=productid;
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprice = productprice;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
}
