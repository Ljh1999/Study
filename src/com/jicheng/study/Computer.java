package com.jicheng.study;

public class Computer {
    private String cpu;
    private int neicun;
    private int yinpan;

    public Computer(String cpu, int neicun, int yinpan) {
        this.setCpu(cpu);
        this.setNeicun(neicun);
        this.setYinpan(yinpan);
    }

    public Computer() {
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getNeicun() {
        return neicun;
    }

    public void setNeicun(int neicun) {
        this.neicun = neicun;
    }

    public int getYinpan() {
        return yinpan;
    }

    public void setYinpan(int yinpan) {
        this.yinpan = yinpan;
    }

    public String getDetails(){
        return "CPU=" + cpu + "内存=" + neicun + "硬盘=" + yinpan;
    }
}
