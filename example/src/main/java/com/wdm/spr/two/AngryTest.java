package com.wdm.spr.two;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AngryConfigure.class)
public class AngryTest {

    @Autowired
    Angry angry;

    @Autowired
    Person person;

    @Test
    public void testAngryNotNull() {
        assertNotNull(angry);
        assertNotNull(person);
    }

    @Test
    public void say() {
        person.say();
    }
}