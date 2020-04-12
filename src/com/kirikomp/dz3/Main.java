package com.kirikomp.dz3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RevertString revertString = new RevertString();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, которую требуется перевернуть (Ограничение по размеру 100 символов!) ");
        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.toLowerCase().equals("q")) {
                System.exit(0);
            }
            System.out.println(revertString.revert(inputString));
        }
    }

}
