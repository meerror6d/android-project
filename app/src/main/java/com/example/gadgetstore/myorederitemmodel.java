package com.example.gadgetstore;

public class myorederitemmodel {

    private int productimage;
    private int rating;
    private String producttitle;
    private String delivery_status;
    private String productdescription;

    public myorederitemmodel(int productimage, int rating, String producttitle, String delivery_status, String productdescription) {
        this.productimage = productimage;
        this.rating=rating;
        this.producttitle = producttitle;
        this.delivery_status = delivery_status;
        this.productdescription = productdescription;
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

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }
}
