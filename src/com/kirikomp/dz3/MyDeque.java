package com.kirikomp.dz3;


import java.util.NoSuchElementException;

public class MyDeque<Item> {

    private MyStack<Item> rightStack = new MyStack<>();

    private MyStack<Item> leftStack = new MyStack<>();


    public void insertRight(Item item) {
        rightStack.push(item);
    }

    public void insertLeft(Item item) {
        leftStack.push(item);
    }

    public Item removeRight() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        balanceIfNeed();

        if (rightStack.isEmpty() && leftStack.size() == 1) {
            return leftStack.pop();
        }

        return rightStack.pop();
    }

    public Item removeLeft() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        balanceIfNeed();

        if (leftStack.isEmpty() && rightStack.size() == 1) {
            return rightStack.pop();
        }

        return leftStack.pop();
    }

    public int size() {
        return leftStack.size() + rightStack.size();
    }

    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    private void balanceIfNeed() {
        if ((leftStack.isEmpty() && rightStack.size() > 1) || (rightStack.isEmpty() && leftStack.size() > 1)) {
            boolean isLeftStackEmpty = leftStack.isEmpty();
            MyStack<Item> notEmptyStack = leftStack.isEmpty() ? rightStack : leftStack;

            MyStack<Item> buffLeft = new MyStack<>();
            MyStack<Item> buffRight = new MyStack<>();

            Object[] buff = new Object[notEmptyStack.size()];
            Object[] left = new Object[notEmptyStack.size() / 2 + 1];
            Object[] right = new Object[notEmptyStack.size() / 2 + 1];

            int k = 0;
            while (!notEmptyStack.isEmpty()) {
                buff[k] = notEmptyStack.pop();
                k++;
            }

            if (isLeftStackEmpty) {
                buff = reverseArray(buff);
            }

            int sizeOfLeftPart = buff.length / 2;

            System.arraycopy(buff, 0, left, 0, sizeOfLeftPart);
            System.arraycopy(buff, sizeOfLeftPart, right, 0, buff.length - sizeOfLeftPart);

            Object[] reversedLeft = reverseArray(left);
            for (int i = 0; i < reversedLeft.length; i++) {
                if (reversedLeft[i] != null) {
                    buffLeft.push((Item) reversedLeft[i]);
                }
            }

            for (int i = 0; i < right.length; i++) {
                if (right[i] != null) {
                    buffRight.push((Item) right[i]);

                }
            }

            leftStack = buffLeft;
            rightStack = buffRight;
        }
    }

    private static Object[] reverseArray(Object[] rawArray) {
        Object[] reversedArray = new Object[rawArray.length];
        for (int i = rawArray.length; i > 0; i--) {
            reversedArray[rawArray.length - i] = rawArray[i - 1];
        }
        return reversedArray;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int i = leftStack.list.length; i > 0; i--) {
            out.append(leftStack.list[i - 1] == null ? "-" : leftStack.list[i - 1]).append(" ");
        }

        out.append("|");

        for (int i = 0; i < rightStack.list.length; i++) {
            out.append(" ").append(rightStack.list[i] == null ? "-" : rightStack.list[i]);
        }

        return out.toString();
    }
}