package com.example.gadgetstore;

import java.util.List;

public class homepafemodel {

    public static final int BANNER_SLIDER=0;
    public static final int STRIP_ADD_SLIDER=1;
    public static final int HORIZONTAL_VIEW=2;
    public static final int gridproductview=3;

    private int type;

    //BANNAR SLIDE
    private List<slider_model>slidermodelList;
    public homepafemodel(int type, List<slider_model> slidermodelList) {
        this.type = type;
        this.slidermodelList = slidermodelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<slider_model> getSlidermodelList() {
        return slidermodelList;
    }
    public void setSlidermodelList(List<slider_model> slidermodelList) {
        this.slidermodelList = slidermodelList;
    }
    //BANNER SLIDE

    ///strip ad layout
    private int resource;
    private String backgroundcolor;
    public homepafemodel(int type,int resource,String backgroundcolor){
        this.type=type;
        this.resource=resource;
        this.backgroundcolor=backgroundcolor;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    public String getBackgroundcolor() {
        return backgroundcolor;
    }
    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }
    //strip ad layout

    //horizontal product layout && grid product
    private String title;
    private List<horizontalscrollmodel>horizontalscrollmodelList;

    public homepafemodel(int type,String title,List<horizontalscrollmodel>horizontalscrollmodelList){
        this.type=type;
        this.title=title;
        this.horizontalscrollmodelList=horizontalscrollmodelList;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public List<horizontalscrollmodel>getHorizontalscrollmodelList(){
        return horizontalscrollmodelList;
    }
    public void setHorizontalscrollmodelList(List<horizontalscrollmodel>horizontalscrollmodelList){
        this.horizontalscrollmodelList=horizontalscrollmodelList;
    }
    //horizontal product layout && grid product

}
