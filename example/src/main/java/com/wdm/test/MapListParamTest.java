package com.wdm.test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by wdmyong on 2017/10/18.
 */
public class MapListParamTest {
    private static class Thing {
        private int id;
        private String name;
        private LocalTime time;

        public Thing(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalTime getTime() {
            return time;
        }

        public void setTime(LocalTime time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<String, List<Thing>> map = new HashMap<>();
        Thing t1 = new Thing(3, "abc");
        Thing t2 = new Thing(3, "abd");
        Thing t3 = new Thing(4, "efg");
        List<Thing> list = new ArrayList<>();
        list.add(t1);
        map.put("key", list);
        List<Thing> list2 = map.get("key");
        list2.add(t2);
        list.add(t3);
        map.values().forEach(System.out::println);

        list = list.stream().sorted(Comparator.comparing(Thing::getId).reversed()
                .thenComparing(Comparator.comparing(Thing::getName).reversed()))
                .collect(toList());
        list.forEach(System.out::println);

        list = list.stream().map(l -> {l.setTime(LocalTime.now()); return l;}).collect(toList());
        list.forEach(System.out::println);

        Optional<String> thingOptional = list.stream()
                .filter(e -> e.getId() == 3)
                .findFirst()
                .map(e -> e.getName());
        System.out.println(thingOptional.isPresent());
        System.out.println(thingOptional.orElse("test"));

        thingOptional = list.stream()
                .filter(e -> e.getId() == 4)
                .findFirst()
                .map(e -> e.getName());
        System.out.println(thingOptional.isPresent());
        System.out.println(thingOptional.orElse("test"));

        thingOptional = list.stream()
                .filter(e -> e.getId() == 5)
                .findFirst()
                .map(e -> e.getName());
        System.out.println(thingOptional.isPresent());
        System.out.println(thingOptional.orElse("test"));

        List<Thing> list1 = Collections.emptyList();
        Map<Integer, Thing> map1 = list1.stream().collect(Collectors.toMap(Thing::getId, thing -> thing));
        map1.put(2, new Thing(2, "jjj"));
        System.out.println(map1.size());
        System.out.println(map1.get(2));
        List<String> list3 = list1.stream().map(m -> m.getName()).collect(toList());
        System.out.println(list3.isEmpty());

        list2.add(new Thing(4, "456"));
        list2.add(new Thing(5, "567"));
        list2.stream().forEach(t -> {
            int tmp = t.getId();
            if (tmp % 2 == 0) {
                t.setName(t.getName() + tmp / 2);
            } else {
                t.setName(t.getName() + tmp);
            }
            t.setTime(LocalTime.now());
        });
        System.out.println("****");
        list2.forEach(System.out::println);
        System.out.println("****");
        list2 = list2.stream().filter(t -> {
            if (t.getId() % 2 == 0) return true;
            return false;
        }).collect(toList());
        System.out.println("----");
        list2.forEach(System.out::println);
        long userId = 123L;
        long visitorId = 456L;
        boolean isLive = true;
        String key = "" + userId + visitorId + isLive;
        System.out.println(key);
        Long a = 12345678L;
        int b = 23713;
        int c = 14918;
        System.out.println(a % b);
        System.out.println(a % b == c);
    }
}
