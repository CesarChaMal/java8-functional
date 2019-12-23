package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_11_iterating {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        String name = "laptop";
        name.chars().mapToObj(st->Character.valueOf((char) st)).forEach(System.out::println);
        System.out.println();
        name.chars().mapToObj(st-> (char) st).forEach(System.out::println);
    }
}
