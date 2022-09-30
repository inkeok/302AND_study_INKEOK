package com.example.ex10_vendingmachine;

public class resultDTO {
    private int num, money;
    private String beverage;

    public resultDTO(int num, int money, String beverage) {
        this.num = num;
        this.money = money;
        this.beverage = beverage;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }
}
