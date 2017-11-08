package com.exper.extend;

/**
 * Created by wdmyong on 2017/11/8.
 */
public class Test {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.setValue(10L);
        outputSubClass(subClass);
        outputBaseClass(subClass);
    }

    public static void outputSubClass(SubClass v) {
        System.out.println(v);
    }

    public static void outputBaseClass(BaseClass v) {
        System.out.println(v);
    }
}
