package com.wdm.example.map;

import java.util.HashMap;
import java.util.Map;

/*
 * 开始尝试看源码，写的low，莫见笑
 * @auth wdmyong
 * 2017/04/13
 */
public class MapKey {

    private int a;
    private int b;

    public MapKey(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return a + b;
    }

    @Override
    public boolean equals(Object obj) {
        MapKey oMapKey = (MapKey)obj;
        if (this.a == oMapKey.a && this.b == oMapKey.b) {
            return true;
        }
        /*
        if (this.a + this.b == oMapKey.a + oMapKey.b) {
            return true;
        }
        //1
        //key: com.wdm.example.map.MapKey@dvalue: 3
        //-------------
        //key: com.wdm.example.map.MapKey@dvalue: 3
        */
        return false;
    }

    /*
     * 输出如下：
     * (说明hashcode一样的情况下，通过equalsto判断相等才是一个)
     * (且keySet()和entrySet()都是取的所有的key集合、所有的节点对集合)
     * (如果equals也是用和的话，那就只有一个)
    3
    key: com.wdm.example.map.MapKey@dvalue: 1
    key: com.wdm.example.map.MapKey@dvalue: 2
    key: com.wdm.example.map.MapKey@dvalue: 3
    -------------
    key: com.wdm.example.map.MapKey@dvalue: 1
    key: com.wdm.example.map.MapKey@dvalue: 2
    key: com.wdm.example.map.MapKey@dvalue: 3
     */
    public static void main(String[] args) {
        Map<MapKey, Integer> map = new HashMap<>();
        MapKey mk1 = new MapKey(1, 12);
        MapKey mk2 = new MapKey(3, 10);
        MapKey mk3 = new MapKey(2, 11);
        map.put(mk1, 1);
        map.put(mk2, 2);
        map.put(mk3, 3);
        System.out.println(map.size());
        for (MapKey key : map.keySet()) {
            System.out.println("key: " + key + "value: " + map.get(key));
        }
        System.out.println("-------------");
        for (Map.Entry<MapKey, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
        }
    }
}
