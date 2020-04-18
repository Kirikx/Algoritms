package com.kirikomp.dz5.Power;

public class Power {
    public static void main(String[] args) throws Exception {
        System.out.println(pow(1,1));
        System.out.println(pow(2,2));
        System.out.println(pow(3,3));
        System.out.println(pow(4,4));
        System.out.println(pow(5,5));
    }

    public static int pow(int osn, int pok) throws Exception{
        if (pok < 0) throw new Exception("Error");
        if (pok == 0) return 1;
        if (pok == 1) return osn;
        return osn * (pow(osn, pok - 1));
    }
}
