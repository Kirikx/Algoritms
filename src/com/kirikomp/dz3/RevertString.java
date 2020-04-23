package com.kirikomp.dz3;

public class RevertString {

    public String revert(String s) {
        MyStack<Character> stack = new MyStack<>();
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
