package com.kirikomp.dz2;

public class MyArr {
    private int[] arr;
    private int size = 0;

    public MyArr(int size) {
        this.arr = new int[size];
    }

    void insert(int item) {
        arr[size] = item;
        size++;
    }

    public void insert(int index, int item) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            index = size;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    public boolean delete(int value) {
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return false;
            }
        }

        for (int j = i; j < this.size - 1; j++){
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
        return true;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int item) {
        arr[index] = item;
    }

    public int size() {
        return size;
    }

    boolean find(int item) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += arr[i] + " ";
        }
        return s;
    }

    private boolean less(int item1, int item2) {
        return item1 < item2;
    }

    private void change(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    void quickSort(int low, int high) {
        if (arr.length == 0)
            return;//завершить выполнение если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = arr[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }
            while (arr[j] > opora) {
                j--;
            }
            if (i<=j) {
                change(i, j);
                i++;
                j--;// меняем местами
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j);
        if (high > i)
            quickSort(i, high);
    }

    void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(arr[j], arr[iMin])) {
                    iMin = j;
                }
            }
            change(i, iMin);
        }
    }

    void insertionSort() {
        int key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = arr[i];

            while (j > 0 && less(key, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

    void bubbleSort() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    change(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

}