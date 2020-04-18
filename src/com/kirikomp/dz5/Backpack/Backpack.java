package com.kirikomp.dz5.Backpack;

public class Backpack {
    static final int MAX_WEIGHT = 80;

    static Goods[] goods = {
            new Goods(15, 30),
            new Goods(30, 90),
            new Goods(50, 100),
            new Goods(10, 10),
            new Goods(20, 40),
            new Goods(15, 35),
            new Goods(80, 100)
    };

    public static void main(String[] args) {
        System.out.println(findBestRes(goods.length - 1, MAX_WEIGHT)); // возвращаем максимальную выгоду от награбленного
    }

    private static int findBestRes(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        if (goods[i].getWeight() > weigth) {
            return findBestRes(i-1, weigth);
        }
        else {
            return Math.max(findBestRes(i-1, weigth), findBestRes(i-1, weigth - goods[i].getWeight()) + goods[i].getValue());
        }
    }
}
