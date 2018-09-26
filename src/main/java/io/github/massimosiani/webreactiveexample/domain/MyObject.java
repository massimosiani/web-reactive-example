package io.github.massimosiani.webreactiveexample.domain;

public class MyObject {
    private String prop1;

    private String prop2;

    private long millis;

    public MyObject(String prop1, String prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }

    public String getProp1() {
        return prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public long getMillis() {
        return millis;
    }

    public MyObject setMillis(long millis) {
        this.millis = millis;
        return this;
    }
}
