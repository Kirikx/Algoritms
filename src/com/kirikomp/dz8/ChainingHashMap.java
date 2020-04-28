package com.kirikomp.dz8;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


public class ChainingHashMap<Key, Value> {
    private int capacity = 7;
    private int size = 0;

    private LinkedList<Node>[] st;

    public ChainingHashMap() {
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node() {};

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key null");
        }
        return true;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key + "=" + node.value+", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Value remove(Key key) {
        isKeyNotNull(key);
        Node nodeReturn = new Node();
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                nodeReturn = node;
                break;
            }
        }
        st[i].remove(nodeReturn);
        size--;
        return nodeReturn.value;


//        Iterator var2 = this.entrySet().iterator();
//        Map.Entry var3 = null;
//        Map.Entry var4;
//        if (key == null) {
//            while(var3 == null && var2.hasNext()) {
//                var4 = (Map.Entry)var2.next();
//                if (var4.getKey() == null) {
//                    var3 = var4;
//                }
//            }
//        } else {
//            while(var3 == null && var2.hasNext()) {
//                var4 = (Map.Entry)var2.next();
//                if (key.equals(var4.getKey())) {
//                    var3 = var4;
//                }
//            }
//        }
//
//        Object var5 = null;
//        if (var3 != null) {
//            var5 = var3.getValue();
//            var2.remove();
//        }
//
//        return var5;
    }
}
