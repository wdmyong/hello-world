package jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> names3 = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> names4 = Arrays.asList("aaaaa", "dddd", "cccc", "bbbbb");
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(names2, (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names3, (String a, String b) -> b.compareTo(a));
        Collections.sort(names4, (a, b) -> b.compareTo(a));
        System.out.println(names1.toString());
        System.out.println(names2.toString());
        System.out.println(names3.toString());
        System.out.println(names4.toString());

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
        Converter<Integer, String> converter2 = (from) -> String.valueOf(from);
        String converted2 = converter2.convert(12345);
        System.out.println(converted2);
    }
}
