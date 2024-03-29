package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8_02_for_each {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");
        for (String names : pack){
            System.out.println(names);
        }
        System.out.println();

        pack.forEach(new Consumer<String>() {
            @Override
            public void accept(String names) {
                System.out.println(names);
            }
        });
        System.out.println();

        pack.forEach((String names) -> System.out.println(names));
        System.out.println();

        pack.forEach((names) -> System.out.println(names));
        System.out.println();

        pack.forEach(names -> System.out.println(names));
        System.out.println();

        pack.forEach(System.out::println);
        System.out.println();
    }
}
