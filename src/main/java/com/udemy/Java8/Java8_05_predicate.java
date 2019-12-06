package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8_05_predicate {
    private static final Logger logger = LogManager.getLogger("Java8");

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();
        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");

        final Predicate<String> filtering = name->name.startsWith("a");
        final List<String> tpack1= pack.stream().filter(filtering).collect(Collectors.toList());
        System.out.println(tpack1);

        final List<String> tpack2 = pack.stream().filter(Java8_05_predicate::test).collect(Collectors.toList());
        System.out.println(tpack2);

        final List<String> tpack3 = pack.stream().filter(criteria("b")).collect(Collectors.toList());
        System.out.println(tpack3);
    }

    private static boolean test(String name) {
        return name.startsWith("a");
    }

    private static Predicate<String> criteria(final String letter) {
        return name->name.startsWith(letter);
    }
}
