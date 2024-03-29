package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Java8_10_collectors_joining {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan", "abraham", "brain", "jack", "skot");
        System.out.println(String.join(",", pack));

        System.out.println(pack.stream().filter(name->name.startsWith("a")).collect(Collectors.joining(",")));
    }
}
