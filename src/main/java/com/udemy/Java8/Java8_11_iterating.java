package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_11_iterating {
    private static final Logger logger = LogManager.getLogger("Java8");

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        String name = "laptop";
        name.chars().mapToObj(st->Character.valueOf((char) st)).forEach(System.out::println);
        System.out.println();
        name.chars().mapToObj(st-> (char) st).forEach(System.out::println);
    }
}
