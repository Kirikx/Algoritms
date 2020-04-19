package com.kirikomp.dz6;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class Main {
//    1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с
//    глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
//    Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
//    2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
    public static void main(String[] args) {
        List<Tree> treeList = new LinkedList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 20; i++) { // создаем 20 деревьев
            Tree tree = new Tree();
            while (tree.levelCount() != 6) { // заполняем деревья пока не достигнем 6 уровней в глубину
                tree.insert(100 - random.nextInt(201));
            }
            treeList.add(tree);
        }

        int count = 0;
        for (int i = 0; i < treeList.size(); i++) {// выявление разбалансированных деревьев
            count += treeList.get(i).isBalance() ? 1 : 0;
        }

        System.out.println(String.format("%s %d", "Количество деревьев:", treeList.size()));
        System.out.println(String.format("%s %d%s", "Процент сбалансированных деревьев:", count * 100 / treeList.size(), "%"));
    }
}
