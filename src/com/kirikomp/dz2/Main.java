package com.kirikomp.dz2;

import java.util.Random;

public class Main {
    public static final int SIZE = 1000000;

    public static void main(String[] args) {
        Random random = new Random();
        MyArr arr = new MyArr(SIZE);

        for (int i = 0; i < SIZE; i++) {
            arr.insert(random.nextInt(SIZE));
        }

        System.out.println("array is created!");
        System.out.println(arr.toString());

//        System.out.println("start selection sort");
//        long a = System.currentTimeMillis();
//        arr.selectionSort();
//        long split = System.currentTimeMillis();
//        System.out.println("Time for selectionSort: "+ (split-a));
//        System.out.println(arr.toString());
//
//        System.out.println("Start insertion sort");
//        long a1 = System.currentTimeMillis();
//        arr.insertionSort();
//        long split1 = System.currentTimeMillis();
//        System.out.println("Time for insertionSort: "+ (split1-a1));
//        System.out.println(arr.toString());
//
//        System.out.println("Start bubble sort");
//        long a2 = System.currentTimeMillis();
//        arr.bubbleSort();
//        long split2 = System.currentTimeMillis();
//        System.out.println("Time for bubbleSort: "+ (split2-a2));
//        System.out.println(arr.toString());

        System.out.println("start quick sort");
        long a3 = System.currentTimeMillis();
        arr.quickSort( 0, SIZE-1);
        long split3 = System.currentTimeMillis();
        System.out.println("Time for quickSort: "+ (split3-a3));
        System.out.println(arr.toString());

        System.out.println(arr.find(9));

    }
}