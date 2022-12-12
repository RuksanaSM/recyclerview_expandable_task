package com.example.recyclerview_expandable_task;

public class ModelClass {
    int placeImage;
    String place;
    int  downarrow,callimage,mapimage,websiteImage;
    String phoneNo,website;
   double longitude, latitude;
    boolean expand;

    public ModelClass(int placeImage, String place, int downarrow, int callimage, int mapimage, int websiteImage, String phoneNo, String website, double longitude, double latitude) {
        this.placeImage = placeImage;
        this.place = place;
        this.downarrow = downarrow;
        this.callimage = callimage;
        this.mapimage = mapimage;
        this.websiteImage = websiteImage;
        this.phoneNo = phoneNo;
        this.website = website;
        this.longitude = longitude;
        this.latitude = latitude;
        this.expand = false;
    }

    public int getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(int placeImage) {
        this.placeImage = placeImage;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getDownarrow() {
        return downarrow;
    }

    public void setDownarrow(int downarrow) {
        this.downarrow = downarrow;
    }

    public int getCallimage() {
        return callimage;
    }

    public void setCallimage(int callimage) {
        this.callimage = callimage;
    }

    public int getMapimage() {
        return mapimage;
    }

    public void setMapimage(int mapimage) {
        this.mapimage = mapimage;
    }

    public int getWebsiteImage() {
        return websiteImage;
    }

    public void setWebsiteImage(int websiteImage) {
        this.websiteImage = websiteImage;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}
