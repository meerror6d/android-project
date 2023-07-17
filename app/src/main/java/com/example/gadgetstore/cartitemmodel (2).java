package com.example.gadgetstore;

public class cartitemmodel {

    public static final int cart_item=0;
    public static final int cart_amount=1;

    private int type;

    //cart item
    private int productimage;
    private String producttitle;
    private String productprice;
    private int productquantity;

    public cartitemmodel(int type, int productimage, String producttitle, String productprice, int productquantity) {
        this.type = type;
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productprice = productprice;
        this.productquantity = productquantity;
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

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //cart item

    //cart total amount
    private String totalitems;
    private String totalamount;
    private String deliveryprice;
    private String TotalAmount;

    public cartitemmodel(int type,String totalItems, String totalamount, String deliveryprice, String TotalAmount) {
        this.type = type;
        this.totalitems = totalItems;
        this.totalamount = totalamount;
        this.deliveryprice = deliveryprice;
        this.TotalAmount = TotalAmount;
    }

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(String deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }


    //cart total amount


}
