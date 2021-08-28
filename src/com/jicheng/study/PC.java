package com.jicheng.study;

public class PC extends Computer {
    private String brand;

    public PC(String cpu, int neicun, int yinpan, String brand) {
        super(cpu, neicun, yinpan);
        this.setBrand(brand);
    }

    public void getpc() {
        System.out.println(" pc信息如下：");
        System.out.println(getDetails() + " 品牌=" + brand);
    }

    public PC() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
