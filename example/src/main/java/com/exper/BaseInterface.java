package com.exper;

/**
 * Created by wdmyong on 2017/11/1.
 */
public interface BaseInterface {

    String DEFAULT_DATA = "default";

    default String getData() {
        System.out.println("BaseInterface getData");
        return DEFAULT_DATA;
    }
}
