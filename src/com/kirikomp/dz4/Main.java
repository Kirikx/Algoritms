package com.kirikomp.dz4;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        int id = 333;
        HashMap<Integer, LinkedList<String>> map = init();
        System.out.println(map.getOrDefault(id, new LinkedList<String>()));

    }

    static HashMap<Integer, LinkedList<String>> init() {
        HashMap<Integer, LinkedList<String>> map = new HashMap<>();
        map.put(220, new LinkedList<String>());
        map.put(333, new LinkedList<String>());
        return map;
    }
}
