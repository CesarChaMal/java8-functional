package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8_07_multiple_lambda {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");

        long number1 = 0L;
        Predicate<String> predicate = ((Function<String, Predicate<String>>) (String letter) -> (String name) -> name.startsWith(letter)).apply("a");
        for (String s : pack) {
            if (predicate.test(s)) {
                number1++;
            }
        }
        System.out.println(number1);

        final long number2 = pack.stream().filter(( (Function<String, Predicate<String>>) new Function<String, Predicate<String>>() {
            @Override
            public Predicate<String> apply(String letter) {
                return new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith(letter);
                    }
                };
            }
        }).apply("a")).count();
        System.out.println(number2);

        final long number3 = pack.stream().filter(( (Function<String, Predicate<String>>) new Function<String, Predicate<String>>() {
            @Override
            public Predicate<String> apply(String letter) {
                return (String name) -> name.startsWith(letter);
            }
        }).apply("a")).count();
        System.out.println(number3);

        final long number4 = pack.stream().filter(((Function<String, Predicate<String>>) (String letter) -> (String name) -> name.startsWith(letter)).apply("a")).count();
        System.out.println(number4);

        final long number5 = pack.stream().filter(((Function<String, Predicate<String>>) (String letter) -> (String name) -> name.startsWith(letter)).apply("a")).count();
        System.out.println(number5);

        final Function<String, Predicate<String>> st1 = (String letter)-> (String name)->name.startsWith(letter);
        final long number6 = pack.stream().filter(st1.apply("a")).count();
        System.out.println(number6);

        final Function<String, Predicate<String>> st2 = Java8_07_multiple_lambda::criteria;
        final long number7 = pack.stream().filter(st2.apply("a")).count();
        System.out.println(number7);

        final long number8 = pack.stream().filter(Java8_07_multiple_lambda.startsWith("j")).count();
        System.out.println(number8);
    }

    private static Predicate<String> startsWith(final String letter) {
        return ((Function<String, Predicate<String>>) Java8_07_multiple_lambda::criteria).apply(letter);
    }

    private static Predicate<String> criteria(final String letter) {
        return name->name.startsWith(letter);
    }
}
