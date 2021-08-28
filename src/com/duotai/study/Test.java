package com.duotai.study;

public class Test {
    public static void main(String[] args) {
        Ptyg p = new Ptyg("小明", 2000);
        Jingli j = new Jingli("王哥", 5000, 5000);
        Test test = new Test();
        test.showEmpAnnal(p);
        test.showEmpAnnal(j);
        test.testWork(p);
        test.testWork(j);
    }

    public void showEmpAnnal(Emoloyee e){
       System.out.println(e.getAnnual());
    }
    public void testWork(Emoloyee e){
        if(e instanceof Ptyg){
            Ptyg p = (Ptyg)e;
            p.work();
        }
        else if (e instanceof Jingli){
            Jingli j = (Jingli) e;
            j.manage();
        }
        else {}
    }
}

