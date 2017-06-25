package com.clblue.android.draglistview;

/**
 * Created by Administrator on 2017/6/25 10:32.
 */

public class ListItemNormal {
    @Override
    public String toString() {
        return "ListItemNormal{" +
                "value='" + value + '\'' +
                ", dst='" + dst + '\'' +
                '}';
    }

    private String value;

    private String dst;

    public ListItemNormal(String value) {
        this.value = value;
    }

    public ListItemNormal(String value, String dst) {
        this.value = value;
        this.dst = dst;
    }

    public ListItemNormal() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
