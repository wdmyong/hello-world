package com.wdm.reflect;

import java.lang.reflect.Array;

public class ArrayTester2 {

    public static void main(String[] args) {
        int[] dims = new int[]{5, 10, 15};
        Object array = Array.newInstance(Long.TYPE, dims);
        Object arrayObj = Array.get(array, 0);
        Class cls = arrayObj.getClass().getComponentType();
        System.out.println(cls);
        arrayObj = Array.get(arrayObj, 5);
        Array.setLong(arrayObj, 10, 37);
        long arrayCast[][][] = (long[][][])array;
        System.out.println(arrayCast[0][5][10]);
    }
}
