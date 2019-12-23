package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8_03_map {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");

        final List<String> packUpper1 = new ArrayList<>();
        for (String names : pack){
            packUpper1.add(names.toUpperCase());
        }
        System.out.println(packUpper1);

        final List<String> packUpper2 = new ArrayList<>();
        pack.forEach(names->packUpper2.add(names.toUpperCase()));
        System.out.println(packUpper2);

        pack.stream().map(name->name.toUpperCase()).forEach(name->System.out.println(name));
        System.out.println();

        pack.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
    }
}
