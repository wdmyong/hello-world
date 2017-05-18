package com.wdm.Exception;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
// import java.util.Date;

/*
 * finally里面的语句会在return之前执行
 * 因此，如果finally里面有return的话，throws以及return都不会执行了
 * 因为已经在finally里面return出去了
 * (throw和return都可以使方法退出，而且可以互相覆盖)
 */
public class TestException {

    public TestException() {  
    }  
  
    @SuppressWarnings("finally")
    boolean testEx() throws Exception {  
        boolean ret = true;  
        try {  
            ret = testEx1();  
        } catch (Exception e) {  
            System.out.println("testEx, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx, finally; return value=" + ret);  
            return ret;  
        }  
    }  
  
    boolean testEx1() throws Exception {  
        boolean ret = true;  
        try {  
            ret = testEx2();  
            if (!ret) {  
                return ret;  
            }  
            System.out.println("testEx1, at the end of try");  
            return ret;  
        } catch (Exception e) {  
            System.out.println("testEx1, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx1, finally; return value=" + ret);
          //return ret;
            // 对ret的改变在try中return返回的时候不会生效
            ret = true;
        }  
    }  
  
    @SuppressWarnings("finally")
    boolean testEx2() throws Exception {  
        boolean ret = true;  
        try {  
            int b = 12;  
            int c;  
            for (int i = 2; i >= -2; i--) {  
                c = b / i;  
                System.out.println("i=" + c);  
            }  
            return true;  
        } catch (Exception e) {  
            System.out.println("testEx2, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx2, finally; return value=" + ret);  
            return ret;  
        }  
    }  
  
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {  
        TestException testException = new TestException();  
        try {  
            testException.testEx();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        ArrayList<String> arrayList1=new ArrayList<String>();  
        arrayList1.add("abc");  
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();  
        arrayList2.add(123);  
        System.out.println(arrayList1.getClass()==arrayList2.getClass());
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();  
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer  
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i=0;i<arrayList3.size();i++) {
            System.out.println(arrayList3.get(i));
        }
        
        /**不指定泛型的时候*/  
        int i = TestException.add(1, 2, true); //这两个参数都是Integer，所以T为Integer类型
        System.out.println(i);
        Number f = TestException.add(1, 1.2, false);//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        System.out.println(f.toString());
        Object o = TestException.add(1, "abc", true);//这两个参数一个是Integer，以风格是String，所以取同一父类的最小级，为Object
        System.out.println(o.toString());
  
                /**指定泛型的时候*/  
        int a = TestException.<Integer>add(1, 2, false);//指定了Integer，所以只能为Integer类型或者其子类
        System.out.println(a);
        // int b = TestException.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float  
        Number c = TestException.<Number>add(1, 2.2, true); //指定为Number，所以可以为Integer和Float 
        System.out.println(c.toString());

        /*
        ArrayList arrayList=new ArrayList();  
        arrayList.add(1);  
        arrayList.add("121");  
        arrayList.add(new Date());
        System.out.println(arrayList.toString());
        */
        ArrayList<String[]> arrayList4 = new ArrayList<>();
        ArrayList<String> arrayList10=new ArrayList<String>();  
        arrayList10.add("123");
        String[] arrayStr = new String[3];
        arrayStr[0] = "kkk1";
        arrayStr[1] = "kkk2";
        arrayStr[2] = "kkk3";
        arrayList4.add(arrayStr);
        System.out.println(arrayList4.toString());
        arrayList10.getClass().getMethod("add", Object.class).invoke(arrayList10, 123);
        // arrayList10.getClass().getMethod("add", Object[].class).invoke(arrayList10, arrayStr);
        arrayList10.getClass().getMethod("add", new Class[]{Object.class}).invoke(arrayList10, new Object[]{a});
        // arrayList.add(123);//编译错误
        System.out.println(arrayList10.toString());
        test1();
    }
    @SuppressWarnings("unchecked")
    private static void test1() {
        ArrayList<String> arrayList1=new ArrayList<String>();  
        arrayList1.add("1");//编译通过  
        //arrayList1.add(1);//编译错误  
        arrayList1.get(0);//返回类型就是String  
          
        @SuppressWarnings("rawtypes")
        ArrayList arrayList2=new ArrayList<String>();  
        arrayList2.add("1");//编译通过  
        arrayList2.add(1);//编译通过  
        arrayList2.get(0);//返回类型就是Object  
        new ArrayList<String>().add("11");//编译通过  
        //new ArrayList<String>().add(22);//编译错误  
        new ArrayList<String>().get(0);//返回类型就是String 
    }
    //这是一个简单的泛型方法  
    public static <T> T add(T x, T y, boolean b){
        if (b) {
            return x;
        }
        return  y;
    }  
}
