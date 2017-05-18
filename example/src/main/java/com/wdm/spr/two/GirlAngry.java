package com.wdm.spr.two;

import org.springframework.stereotype.Component;

@Component("angry")
public class GirlAngry implements Angry {

    private static String WHY = "why";
    @Override
    public void say() {
        System.out.println(WHY);
    }

}
