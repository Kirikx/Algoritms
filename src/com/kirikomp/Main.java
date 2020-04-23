package com.kirikomp;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Есть класс
//
//        Company {
//            Integer id;
//            Integer parentId;
//            List<Company> list;
//        }
//
//        если parentId null - это объект верхнего уровня
//
//        необходимо собрать дерево из данных
//
//        id parentId
//        1  0
//        2  0
//        3  1
//        4  3
//        5  4
//        6  0

        Company company1 = new Company(1, 0);
        Company company2 = new Company(2, 0);
        Company company3 = new Company(3, 1);
        Company company4 = new Company(4, 3);
        Company company5 = new Company(5, 4);
        Company company6 = new Company(6, 0);

        Company[] companies = new Company[]{company1, company2, company3, company4, company5, company6};

        Company[] treeCompany = toTree(companies);

        System.out.println("--- Дерево ---");

        for (Company company : treeCompany) {
            System.out.println(company);
        }


    }

    private static Company[] toTree(Company[] companies) {
        Company[] root = new Company[companies.length];
        Company[] result;
        int sizeRoot = 0;

        System.out.println("--- Исходный массив ---");

        for (int i = 0; i <companies.length ; i++) {
            System.out.println(companies[i]);
            if (companies[i].getParentId() == 0) {
                root[sizeRoot] = companies[i];
                sizeRoot++;
            }
        }
        result = new Company[sizeRoot];
        for (int i = 0; i <sizeRoot ; i++) {
            root[i].accept(companies);
            result[i] = root[i];
        }
        return result;
    }

}

class Company {

    Integer id;
    Integer parentId;
    List<Company> list = new LinkedList<>();
    Company parent;

    public Company(Integer id, Integer parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Company> getList() {
        return list;
    }

    public void setList(List<Company> list) {
        this.list = list;
    }

    public void addToList(Company company) {
        company.parent = this;
        getList().add(company);
    }

    public void accept(Company[] companies) {
        for(int i = 0; i < companies.length; i++ ) {
            if(companies[i].parentId == this.id) {
                addToList(companies[i]);
                companies[i].accept(companies);
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", list=" + list +
                '}';
    }
}
