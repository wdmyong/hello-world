package com.exper;

/**
 * Created by wdmyong on 2017/11/1.
 */
public abstract class BaseAbstract implements BaseInterface {

    private String data;

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        System.out.println("BaseAbstract getData");
        return data;
    }
}
