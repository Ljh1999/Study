package com.FangWuChuZu.View;

import com.FangWuChuZu.Model.House;
import com.FangWuChuZu.Service.HouseService;

import java.util.Scanner;

public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接受用户选择
    Scanner scanner = new Scanner(System.in);
    HouseService houseService = new HouseService(2);

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("----------房屋出租系统----------");
            System.out.println("1 新增房源");
            System.out.println("2 查找房源");
            System.out.println("3 删除房源");
            System.out.println("4 修改房源");
            System.out.println("5 房屋列表");
            System.out.println("6 退出系统");
            System.out.print("请输入你的选择（1-6）:");
            key = scanner.next().charAt(0);
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findbyid();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("您的输入有误！");
            }
        } while (loop);
    }

    //根据ID查找房屋信息
    public void findbyid(){
        System.out.println("---------查找房屋----------");
        System.out.print("请输入要查找的房屋id：");
        int i = scanner.nextInt();
        System.out.println(houseService.find(i));
    }

    //根据name查找房屋信息
    public void findbyname(){
        System.out.println("---------查找房屋----------");
        System.out.print("请输入要查找的业主名称：");
        String next = scanner.next();
        System.out.println(houseService.findbyname(next));
    }

    //退出
    public void exit() {
        while (true) {
            System.out.print("确认退出吗系统吗？（y/n）：");
            char c = scanner.next().charAt(0);
            if (c != 'y' && c != 'n') {
                System.out.println("您的输入有误！请重新输入!");
            } else if (c == 'n') {
                break;
            } else if (c == 'y') {
                loop = false;
                break;
            }
        }
    }

    //显示房屋列表
    public void listHouse() {
        System.out.println("---------房屋列表----------");
        System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址" + "\t\t" + "月租" + "\t\t" + "状态（未出租/已出租）");
        for (int i = 0; i < houseService.list().length; i++) {
            if (houseService.list()[i] == null) {
                break;
            }
            System.out.print(houseService.list()[i] + "\n");
        }
        System.out.println("---------房屋列表完成----------");
    }

    //新增房屋信息
    public void addHouse() {
        System.out.println("---------添加房屋----------");
        System.out.print("姓名：");
        String name = scanner.next();
        System.out.print("电话：");
        String phone = scanner.next();
        System.out.print("地址：");
        String address = scanner.next();
        System.out.print("月租：");
        int rent = scanner.nextInt();
        System.out.print("状态：");
        String state = scanner.next();
        House house = new House(2, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("添加完成");
        } else {
            System.out.println("添加失败");
        }
    }

    //删除房屋信息
    public void delHouse() {
        System.out.println("---------删除房屋----------");
        System.out.print("请选择待删除房屋编号（-1退出）：");
        int chois = scanner.nextInt();
        if (chois == -1) {
            System.out.println("你放弃了删除！");
            return;
        }

        while (true) {
            System.out.println("确认删除吗？（y/n）：");
            char c = scanner.next().charAt(0);
            if (c != 'y' && c != 'n') {
                System.out.println("您的输入有误！请重新输入!");
            } else if (c == 'n') {
                System.out.println("你放弃了删除房屋信息！");
                break;
            } else if (c == 'y') {
                if (houseService.del(chois)) {
                    System.out.println("删除成功！");
                    break;
                } else {
                    System.out.println("删除失败！房号不存在！");
                    break;
                }
            }
        }
    }
    public void updateHouse(){
        System.out.println("---------修改房屋----------");
        System.out.print("请输入待修改的房屋编号：");
        int i = scanner.nextInt();
        House house = houseService.find(i);
        if(house!=null){
        System.out.print("姓名("+house.getName()+"):");
        String name = scanner.next();
        System.out.print("电话(" + house.getPhone()+"):");
        String phone = scanner.next();
        System.out.print("地址(" + house.getAddress()+"):");
        String address = scanner.next();
        System.out.print("月租(" + house.getRent()+"):");
        int rent = scanner.nextInt();
        System.out.print("状态(" + house.getState()+"):");
        String state = scanner.next();
        house.setName(name);
        house.setPhone(phone);
        house.setAddress(address);
        house.setRent(rent);
        house.setState(state);
        }
        else {
            System.out.println("该房屋信息不存在！");
        }
    }
}
