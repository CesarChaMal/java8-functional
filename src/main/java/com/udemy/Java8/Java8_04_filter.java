package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_04_filter {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");

        final List<String> tpack = pack.stream().filter(name->name.startsWith("a")).collect(Collectors.toList());
        System.out.println(tpack);
    }
}
