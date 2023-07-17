package com.example.gadgetstore;

public class wishlistmodel {
    private int productimage;
    private String producttitle;
    private String rating;
    private String productprice;
    private String paymentmethod;


    public wishlistmodel(int productimage, String producttitle, String rating, String productprice, String paymentmethod) {
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.rating = rating;
        this.productprice = productprice;
        this.paymentmethod = paymentmethod;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }
}
