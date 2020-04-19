package com.kirikomp.dz6;

public class TreeNode { //класс являющийся узлом бинарного дерева
    int value; //значение узла

    public TreeNode left; // подчиненный левый наследник
    public TreeNode right; // подчиненный правый наследник

    protected TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
