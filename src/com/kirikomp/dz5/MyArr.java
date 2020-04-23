package com.kirikomp.dz5;

class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int binaryFind(int search) {
        int index = recBinaryFind(search, 0, size - 1);
        if (index != -1)
        System.out.println(true);
        else throw new NullPointerException("Элемент не найден!!!");
        return index;
    }

    private int recBinaryFind(int searchKey, int low, int high) {
        if (high >= low) {
            int curIn = low + (high - low) / 2;
            if (arr[curIn] == searchKey)
                return curIn;
            if (arr[curIn] < searchKey)
                return recBinaryFind(searchKey, curIn + 1, high);

                return recBinaryFind(searchKey, low, curIn - 1);
        }
        return -1;
    }

    public void insert(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] > value)
                break;
        }
        for (int j = this.size; j > i; j--) {
            this.arr[j] = this.arr[j - 1];
        }
        this.arr[i] = value;
        this.size++;
    }
}

class MyArrApp {
    public static void main(String[] args) {
        MyArr arr = new MyArr(3);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);

        int search = 2;

        System.out.println(arr.binaryFind(search));
    }
}
