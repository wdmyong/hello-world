package jdk8;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import static jdk8.Threshold.TEST;

/**
 * Created by wdmyong on 2017/11/7.
 */
public class ThresholdTest {

    public static void main(String[] args) {
        System.out.println(TEST.getPrefix());
        System.out.println(TEST.getLimit());
        System.out.println(TEST.getExpireInMs());
        System.out.println(NumberUtils.toLong(null));
        int[] a = new int[]{2,1};
        System.out.println(a.length);
        System.out.println(a[0]);
        Map<Long, int[]> map = new HashMap<>();
        int[] b = map.computeIfAbsent(123L, id -> new int[]{0});
        b[0]--;
        System.out.println(b[0]);
        System.out.println(map.get(123L)[0]);
        map.keySet();
        map.entrySet();

        Threshold threshold = null;
        if (a.length == 1) {
            threshold = Threshold.TEST;
        }
        if (threshold != null) {
            System.out.println(threshold.getExpireInMs());
        } else {
            System.out.println("enum is null");
        }
        long al = 0L;
        long bl = 0L;
        double cl = ((double)al) / bl;
        System.out.println(cl > 1);
    }

}
