package com.wdm.reflect;

import java.lang.reflect.Array;

public class ArrayTester1 {

    public static void main(String[] args) throws Exception {
        Class<?> classType = Class.forName("com.wdm.reflect.Customer");
        Object array = Array.newInstance(classType, 10);
        Array.set(array, 6, new Customer("name"));
        Customer customer = (Customer) Array.get(array, 6);
        System.out.println(customer.toString());
    }
}
