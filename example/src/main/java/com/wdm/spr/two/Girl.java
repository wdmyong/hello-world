package com.wdm.spr.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl implements Person {

    private Angry angry;

    @Autowired
    public Girl(Angry angry) {
        this.angry = angry;
    }

    @Autowired
    public void insertAngry(Angry angry) {
        this.angry = angry;
    }

    @Override
    public void say() {
        angry.say();
    }

}
