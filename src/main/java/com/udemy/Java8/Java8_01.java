package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8_01 {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("My Runnable");
//            }
//        };
        Runnable runnable = () -> System.out.println("My Runnable");
    }
}
