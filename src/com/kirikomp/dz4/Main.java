package com.kirikomp.dz4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

//        int id = 333;
//        HashMap<Integer, LinkedList<String>> map = init();
//        System.out.println(map.getOrDefault(id, new LinkedList<String>()));
        MyLinkedList<String> mll = new MyLinkedList<>();

        mll.insertFirst("Katia");
        mll.insertFirst("Maria");
        mll.insertFirst("Lyba");

        System.out.println(mll);

        mll.insertLast("Petia");
        System.out.println(mll);


        mll.insert("Vasia", 1);
        System.out.println(mll);


        Iterator<String> iterator = mll.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        Iterator<String> iter = mll.iterator();
        while(iter.hasNext()){
            if(iter.next().contains("t")){
                iter.remove();
            }
        }

        System.out.println();

        for (String s : mll) {
            System.out.print(s + " : ");
        }

        String[] mass = new String[10];
        MyObj<String> stringMyObj = new MyObj<>(mass);

    }

    static HashMap<Integer, LinkedList<String>> init() {
        HashMap<Integer, LinkedList<String>> map = new HashMap<>();
        map.put(220, new LinkedList<String>());
        map.put(333, new LinkedList<String>());
        return map;
    }
}
