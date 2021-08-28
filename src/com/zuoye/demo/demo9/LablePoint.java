package com.zuoye.demo.demo9;

public class LablePoint extends Point {
    private String lable;

    public LablePoint(double x, double y, String lable) {
        super(x, y);
        this.lable = lable;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
