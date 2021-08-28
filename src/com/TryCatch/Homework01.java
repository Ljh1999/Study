package com.TryCatch;

public class Homework01 {
    public static void main(String[] args) {
        Integer k = new Integer(1);
        Integer integer = Integer.valueOf(1);
        Integer j = new Integer(1);
       System.out.println(k==j);
        try {
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数不正确！");
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            double cal = cal(num1, num2);
            System.out.println("计算结果为：" + cal);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException n){
            System.out.println("参数格式不 正确！");
        }catch (ArithmeticException a){
            System.out.println("除数不能为0！");
        }
    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
