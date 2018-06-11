package com.example.sonhyejin.eat_ku;

public class Ingredient {
    String num;
    String name;
    String sort;
    int have;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getHave() {
        return have;
    }

    public void setHave(int have) {
        this.have = have;
    }

    public Ingredient(String num, String name, String sort, int have) {
        this.num = num;
        this.name = name;
        this.sort = sort;
        this.have = have;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
