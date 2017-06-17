package com.wdm.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    class Food {
        private String name;

        public Food(){};
        public Food(String name) {
            this.name = name;
        }
        public void serveFood() {
            System.out.println("I'm serving " + name);
        }
    }

    class FoodFactory extends Food {

        
        public FoodFactory(String name) {
            super(name);
        }

        public Food getFood(String name) {
            return new Food(name);
        }
    }
    
}
