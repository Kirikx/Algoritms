package com.kirikomp.dz6;

public class Tree {
    private TreeNode root;
    private int lh = 0;
    private int rh = 0;

    public void insert(int value) { // вставка элемента в дерево
        TreeNode node = new TreeNode(value);
        if (root == null) { // если вставка осуществляется в пустое дерево, элемент назначается корневым
            root = node;

        } else { // вставка в крайний элемент дерева с учетом веса
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }

                }
            }
        }
    }

    private void leftHeight(TreeNode root) { // высота левой части
        if (root != null) {
            leftHeight(root.left);
            lh = lh + 1;
        }
    }

    private void rightHeight(TreeNode root) { // высота правой части
        if (root != null) {
            rightHeight(root.right);
            rh = rh + 1;
        }
    }

    public int levelCount () { // подсчет глубины дерева
        int count = 0;
        leftHeight(root);
        rightHeight(root);
        count = Math.max(lh, rh);
        lh = 0;
        rh = 0;
        return count;
    }

    public boolean isBalance() { // проверка на сбалансированность дерева
        leftHeight(root);
        rightHeight(root);
        int res = lh - rh;
        lh = rh = 0;
        return res <= 1;
    }

}
