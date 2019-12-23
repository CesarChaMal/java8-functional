package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8_08_optional {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan", "abraham", "brain", "jack", "skot");
        pickname(pack, "j");
        System.out.println();

        picknameWithOptional(pack, "j");
        System.out.println();
    }

    private static void pickname(final List<String> names, String startingLetter) {
        String namefound = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                namefound = name;
                break;
            }
        }

        if (namefound == null) {
            System.out.println("no name found");
        } else {
            System.out.println("name starting with " + startingLetter + ":" + namefound);
        }
    }

    private static void picknameWithOptional(final List<String> names, String startingLetter) {
        final Optional<String> namefound = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
        System.out.println("the first name that begins with " + startingLetter + ":" + namefound.orElse("no name was found"));
        namefound.ifPresent(name-> System.out.println("way we found it"));
    }
}
