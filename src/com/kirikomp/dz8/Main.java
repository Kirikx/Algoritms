package com.kirikomp.dz8;

import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

//        LinearProbingHashMap<Integer,String> map1 = new LinearProbingHashMap<>();
        ChainingHashMap<Integer,String> map1 = new ChainingHashMap<>();
        map1.put(1,"one");
        map1.put(2,"two");
        map1.put(12,"12");
        map1.put(15,"15");

        System.out.println(map1.get(1));
        map1.put(1,"1");
        System.out.println(map1.get(1));
        map1.remove(1);
        System.out.println(map1.get(1));

    }

    private static void showPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        int lenght = 0;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
            lenght++;
        }
        System.out.println(sb);
        System.out.println("path " + lenght);
    }
}
