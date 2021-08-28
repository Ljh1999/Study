package com.duotai.study;

public class Jingli extends Emoloyee {
    private double bonus;

    public Jingli(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println(" 经理：" + getName() + "管理员工");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
