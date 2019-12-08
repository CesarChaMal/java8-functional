package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Java8_09_reducing_operations {
    private static final Logger logger = LogManager.getLogger("Java8");

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan", "abraham", "brain", "jack", "skot");

//        with loop
        int sum = 0;
        for (String s : pack) {
            int length = s.length();
            sum += length;
        }
        System.out.println("the total number of characters: " + sum);

//        with anonymous class
        System.out.println("the total number of characters: " + pack.stream().mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String name) {
                return name.length();
            }
        }).sum());

//        with lambda implementing function
        ToIntFunction<String> stringToIntFunction = (String name) -> {
            return name.length();
        };
        System.out.println("the total number of characters: " + pack.stream().mapToInt(stringToIntFunction).sum());

//        with lambda inline
        System.out.println("the total number of characters: " + pack.stream().mapToInt((String name)-> {
            return name.length();
        }).sum());
//        with lambda inline 2
        System.out.println("the total number of characters: " + pack.stream().mapToInt((String name)->name.length()).sum());
//        with lambda inline 3
        System.out.println("the total number of characters: " + pack.stream().mapToInt(name->name.length()).sum());
//        with method reference
        System.out.println("the total number of characters: " + pack.stream().mapToInt(String::length).sum());

        System.out.println("the maximum length of characters: " + pack.stream().mapToInt(String::length).max().getAsInt());
        System.out.println("the minimum length of characters: " + pack.stream().mapToInt(String::length).min().getAsInt());
        System.out.println("the average length of characters: " + pack.stream().mapToInt(String::length).average().getAsDouble());

        System.out.println("the longest name is: " + pack.stream().reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String name1, String name2) {
                return name1.length() > name2.length() ? name1 : name2;
            }
        }).get());

        BinaryOperator<String> stringBinaryOperator1 = (name1, name2) -> {
            return name1.length() > name2.length() ? name1 : name2;
        };
        System.out.println("the longest name is: " + pack.stream().reduce(stringBinaryOperator1).get());

        BinaryOperator<String> stringBinaryOperator2 = (String name1, String name2) -> {
            return name1.length() > name2.length() ? name1 : name2;
        };
        System.out.println("the longest name is: " + pack.stream().reduce(stringBinaryOperator2).get());

        BinaryOperator<String> stringBinaryOperator3 = (name1, name2) -> name1.length() > name2.length() ? name1 : name2;
        System.out.println("the longest name is: " + pack.stream().reduce(stringBinaryOperator3).get());

        System.out.println("the longest name is: " + pack.stream().reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2).get());
        System.out.println("the longest name is: " + pack.stream().reduce(Java8_09_reducing_operations::apply).get());
    }

    private static String apply(String name1, String name2) {
        return name1.length() > name2.length() ? name1 : name2;
    }
}
