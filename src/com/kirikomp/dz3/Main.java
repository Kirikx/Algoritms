package com.kirikomp.dz3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        RevertString revertString = new RevertString();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите строку, которую требуется перевернуть (Ограничение по размеру 100 символов!) ");
//        while (true) {
//            String inputString = scanner.nextLine();
//            if (inputString.toLowerCase().equals("q")) {
//                System.exit(0);
//            }
//            System.out.println(revertString.revert(inputString));
//        }

        MyDeque<Integer> deque = new MyDeque<>();

        deque.insertLeft(3);
        deque.insertLeft(2);
        deque.insertLeft(1);

        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);

        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        System.out.println(!deque.isEmpty());
        deque.removeRight();
        System.out.println(deque.isEmpty());
        System.out.println(deque);
    }

}
