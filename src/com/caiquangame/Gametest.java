package com.caiquangame;

import java.util.Random;
import java.util.Scanner;

public class Gametest {
    public static void main(String[] args) {
        Person t = new Person();
        //用来记录比赛最后输赢
        int isWinCount = 0;
        //创建一个二维数组来接收局数，person出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;

        //接受输赢情况
        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {//比赛3次
            //获取玩家出的拳
            System.out.println(" 请输入你要出的拳（0-拳头，1-剪刀，2-步）");
            int num = scanner.nextInt();
            t.setPersonnum(num);
            int tomGuess = t.getPersonnum();
            arr1[i][j + 1] = tomGuess;

            //获取电脑出的拳
            int comGuess = t.range();
            arr1[i][j + 2] = comGuess;

            //将玩家出的拳和电脑做比较
            String isres = t.vscomputer();
            arr2[i] = isres;
            arr1[i][j] = t.count;

            //对每一局的情况进行输出
            System.out.println(" ================");
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t\t输赢情况");
            System.out.println(" " + t.count + "\t\t" + tomGuess + "\t\t\t" + comGuess + "\t\t\t" + t.vscomputer());
            System.out.println(" ================");
            System.out.println("\n\n ");
            isWinCount = t.wincout(isres);
        }
        //对游戏最终的结果进行输出
        System.out.println("局数\t\t玩家的出拳\t电脑的出拳\t\t输赢情况");
        for (int a = 0; a < arr1.length; a++) {
            for (int b = 0; b < arr1[a].length; b++) {
                System.out.print(arr1[a][b] + "\t\t\t");
            }
            System.out.print(arr2[a]);
            System.out.println();
        }
        System.out.println("你赢了 " + isWinCount + "次");
    }
}

class Person {
    //玩家出拳的类型
    int personnum;
    //电脑出拳的类型
    int computernum;
    //玩家赢的次数
    int wincount;

    //电脑随机生成猜拳的方法
    public int range() {
        Random random = new Random();
        computernum = random.nextInt(3);
        return computernum;
    }

    public void setPersonnum(int personnum) {
        if (personnum >= 0 && personnum <= 2) {
            this.personnum = personnum;
        } else {
            System.out.println(" 输入的拳只能在0-2之间");
        }
    }

    public int getPersonnum() {
        return personnum;
    }

    //比赛次数
    int count = 1;

    //比赛的结果
    public String vscomputer() {
        if (personnum == 0 && computernum == 1) {
            return "你赢了";
        } else if (personnum == 1 && computernum == 2) {
            return "你赢了";
        } else if (personnum == 2 && computernum == 0) {
            return "你赢了";
        } else if (personnum == computernum) {
            return "平手";
        } else {
            return "你输了";
        }
    }

    //记录玩家赢的次数
    public int wincout(String s) {
        count++;
        if (s.equals("你赢了")) {
            wincount++;
        }
        return wincount;
    }
}
