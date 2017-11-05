package com.wdm.blog;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdmyong on 2017/10/10.
 */
public class MapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put(null, "abc");
        map.put("abc", null);
        map.put("def", null);
        //System.out.println(map.get(null));
        //System.out.println(map.get("abc"));
        //System.out.println(map.get("def"));
        //System.out.println(map.get("kkk"));
        //System.out.println(map.containsKey("abc"));
        //System.out.println(map.containsKey("kkk"));
        String[] arr = new String[10];
        arr[0] = "1";
        fu(arr);
        //System.out.println(arr[2]);
        String s2 = "  的当天你在干什么，又在想什么", s1 = "\t\t\t\t\t请问一下  ";
        LocalDate localDate = LocalDate.now();
        System.out.println( );System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println(" ");System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println( " ");System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println( " ");System.out.println();System.out.println();System.out.println();System.out.println();
        Thread.sleep(5000L);
        for (int i = 0; i < 10; i++) {
            System.out.println(s1 + localDate.minusYears(10 - i) + s2);
            System.out.println();System.out.println();
            Thread.sleep(1000L);
        }
        System.out.println("\t\t这多么的当天是否有想到  " + localDate + "  的今天会在这里做现在做的事呢");
    }
    public static void fu(String[] arr) {
        arr[2] = "asdf";
    }
}
