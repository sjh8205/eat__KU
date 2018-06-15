package com.example.sonhyejin.eat_ku;

/**
 * Created by user on 2016-08-10.
 */
public class SingerItem {

    String name;
    int resId;

    public SingerItem(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

