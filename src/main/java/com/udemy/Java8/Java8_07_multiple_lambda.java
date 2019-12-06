package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8_07_multiple_lambda {
    private static final Logger logger = LogManager.getLogger("Java8");

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");
        final Function<String, Predicate<String>> st = (String letter)-> (String name)->name.startsWith(letter);
        final long number = pack.stream().filter(st.apply("a")).count();
        System.out.println(number);
    }

    private static Predicate<String> criteria(final String letter) {
        return name->name.startsWith(letter);
    }
}
