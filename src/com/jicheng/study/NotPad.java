package com.jicheng.study;

public class NotPad extends PC {


    private String color;

    public NotPad(String cpu, int neicun, int yinpan, String brand, String color) {
        super(cpu, neicun, yinpan, brand);
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void getnotpad() {
        System.out.println(" 信息如下：");
        System.out.println(getDetails()+"使用"+getBrand()+"演示"+color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NotPad() {

    }
}
