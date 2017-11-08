package com.exper.extend;

/**
 * Created by duanyong on 2017/11/8.
 */
public class SubClass extends BaseClass {

    private Long value;

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void setValue(Long value) {
        this.value = value;
    }
}
