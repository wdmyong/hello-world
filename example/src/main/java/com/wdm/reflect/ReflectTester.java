package com.wdm.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectTester {

    @SuppressWarnings("rawtypes")
    public Object copy(Object object) throws Exception {
        //Class classType = object.getClass();
        //Class classType = Class.forName("Customer");  // 报错，需要全局限定名
        Class<?> classType = Class.forName("com.wdm.reflect.Customer");
        System.out.println("Class:\t" + classType.getName());
        Object objectCopy = classType.getConstructor(new Class[]{String.class}).newInstance(new Object[]{"wdm"});
        Field[] fields = classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String firstL = fieldName.substring(0, 1).toUpperCase();

            String getMethodName = "get" + firstL + fieldName.substring(1);
            String setMethodName = "set" + firstL + fieldName.substring(1);

            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});

            Object value = getMethod.invoke(object, new Object[]{});
            System.out.println(fieldName + ":\t" + value);
            setMethod.invoke(objectCopy, new Object[]{value});
        }
        Method[] methods = classType.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method.toString());
            Class[] fieldTypes = method.getParameterTypes();
            for (int j = 0; j < fieldTypes.length; j++) {
                System.out.println(fieldTypes[j].toString());
            }
        }
        return objectCopy;
    }


    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        customer.setName("CJ");
        customer.setAge(18);
        customer.setId(1L);
        Customer customerCopy = (Customer) new ReflectTester().copy(customer);
        System.out.println("Copy information:\t" + customerCopy.toString());
    }
}
