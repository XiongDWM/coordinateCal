package com.xiongdwm.cordinalteCal;

public class LatLng {
    private double lng;
    private double lat;

    public LatLng(){

    }
    public LatLng(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
