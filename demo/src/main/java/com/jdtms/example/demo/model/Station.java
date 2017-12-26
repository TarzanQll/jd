package com.jdtms.example.demo.model;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: nyh
 * \* Date: 17-10-31
 * \* Time: 下午4:29
 * \* Description:
 * \
 */

public class Station {
    private String name = "";
    private String lng = "121.20";
    private String lat = "31.28";
    private int order = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
