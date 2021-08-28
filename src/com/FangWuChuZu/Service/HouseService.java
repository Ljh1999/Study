package com.FangWuChuZu.Service;

import com.FangWuChuZu.Model.House;

public class HouseService {

    private House[] houses;//定义一个存放房屋的数组
    private int housenum = 1;//记录当前有多少个房屋信息
    private int idcount = 1;//记录当前的id增长值

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "邓志刚", "151",
                "湖南涉外", 500, "未出租");
    }

    //返回所有房屋信息
    public House[] list() {
        return houses;
    }

    //通过id查找房屋信息
    public House find(int id){
        for (int i = 0; i < housenum; i++) {
            if(id==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    public House findbyname(String name){
        for (int i = 0; i < housenum; i++) {
            if(name.equals(houses[i].getName())){
                return houses[i];
            }
        }
        return null;
    }

    //添加房屋信息
    public boolean add(House house) {
        if (houses.length != housenum) {
            houses[housenum] = house;
            housenum++;
            idcount++;
            house.setId(idcount);
            return true;
            //System.out.println("数组已满，不能添加了！");
            //return false;
        } else {
            while (true) {
                House[] houses2 = new House[houses.length + 1];
                for (int i = 0; i < houses.length; i++) {
                    houses2[i] = houses[i];
                }
                houses = houses2;
                houses[housenum] = house;
                housenum++;
                idcount++;
                house.setId(idcount);
                return true;
            }
        }
    }

    //删除房屋
    public boolean del(int id){
        int index = -1;
        for (int i = 0; i < housenum; i++) {
             if(houses[i].getId()==id){
                    index = i;
             }
        }
        if(index==-1){
            return false;
        }
        for (int i = index; i < housenum-1; i++) {
          houses[i] = houses[i+1];
        }
        houses[housenum-1] = null;
        housenum--;
        return true;
    }
}
