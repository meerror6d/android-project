package com.example.gadgetstore;

public class productspecificationmodel {

    public static final int specification_title=0;
    public static final int specification_body=1;
    private int type;

    ///spcification title
    private String title;

    public productspecificationmodel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ///spcification title

    //specification body
    private String featurename;
    private String featurevalue;

    public productspecificationmodel(int type,String featurename, String featurevalue) {
        this.type = type;
        this.featurename = featurename;
        this.featurevalue = featurevalue;
    }

    public String getFeaturevalue() {
        return featurevalue;
    }

    public void setFeaturevalue(String featurevalue) {
        this.featurevalue = featurevalue;
    }

    public String getFeaturename() {
        return featurename;
    }

    public void setFeaturename(String featurename) {
        this.featurename = featurename;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    //specification body

}
