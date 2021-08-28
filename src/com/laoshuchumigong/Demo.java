package com.laoshuchumigong;

public class Demo {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //0表示可以走的路，1表示障碍物

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[0][j] = 1;
                map[7][j] = 1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][0] = 1;
                map[i][6] = 1;
            }
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[2][1] = 1;
//        map[2][2] = 1;
//        map[1][2] = 1;
        T t = new T();
        t.findWay(map,1,1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class T {
    //递归回溯
    //如果找到返回true，否则返回false
    //map表示迷宫
    //i,j表示老师的位置，初始位置为1,1
    //0 表示可以走的路，但还没走过 1 表示障碍物 2 表示走过了，可以走 3 表示走过，但是是死路
    //map[6][5]=2 说明找到通路，可以结束，否则就继续找
    //确定找路策略 右-下-左-上
    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if(findWay(map,i,j+1)){
                    return true;
                }else if(findWay(map,i+1,j)){
                    return true;
                }else if(findWay(map,i,j-1)){
                    return true;
                }else if(findWay(map,i-1,j)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            } else {   //只能为1,2,3
                return false;
            }
        }

    }
}
