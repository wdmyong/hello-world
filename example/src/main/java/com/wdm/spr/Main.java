package com.wdm.spr;

// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/KnightsAop.xml");
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfigure.class);
        Knight knight = context.getBean(Knight.class);
        knight.embark();
        context.close();
    }
}
