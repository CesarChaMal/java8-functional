package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8_06_function {
    private static final Logger logger = LogManager.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final List<String> pack = Arrays.asList("alan","abraham","brain","jack","skot");

        final Function<String, Predicate<String>> st1 = new Function<String, Predicate<String>>() {
            @Override
            public Predicate<String> apply(String letter) {
                return new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith(letter);
                    }
                };
            }
        };
        final List<String> tpack1 = pack.stream().filter(st1.apply("s")).collect(Collectors.toList());
        System.out.println(tpack1);

        final Function<String, Predicate<String>> st2 = new Function<String, Predicate<String>>() {
            @Override
            public Predicate<String> apply(String letter) {
                Predicate<String> criteria = (String name) -> {
                    return name.startsWith(letter);
                };
                return criteria;
            }
        };
        final List<String> tpack2 = pack.stream().filter(st2.apply("a")).collect(Collectors.toList());
        System.out.println(tpack2);

        final Function<String, Predicate<String>> st3 = (String letter)->{
            Predicate<String> criteria = (String name)-> {
                return name.startsWith(letter);
            };
            return criteria;
        };
        final List<String> tpack3 = pack.stream().filter(st3.apply("a")).collect(Collectors.toList());
        System.out.println(tpack3);

        final Function<String, Predicate<String>> st4 = (String letter)->{
            Predicate<String> criteria = (String name)->name.startsWith(letter);
            return criteria;
        };
        final List<String> tpack4 = pack.stream().filter(st4.apply("a")).collect(Collectors.toList());
        System.out.println(tpack4);
        System.out.println();

        final Function<String, Predicate<String>> st5 = (String letter)->{
            return (String name)->name.startsWith(letter);
        };
        final List<String> tpack5 = pack.stream().filter(st5.apply("a")).collect(Collectors.toList());
        System.out.println(tpack5);
        System.out.println();

        final Function<String, Predicate<String>> st6 = (String letter)-> (String name)->name.startsWith(letter);
        final List<String> tpack6 = pack.stream().filter(st6.apply("a")).collect(Collectors.toList());
        System.out.println(tpack6);
        System.out.println();

        final Function<String, Predicate<String>> st7 = letter -> name ->name.startsWith(letter);
        final List<String> tpack7 = pack.stream().filter(st7.apply("a")).collect(Collectors.toList());
        System.out.println(tpack7);
        System.out.println();

        final Function<String, Predicate<String>> st8 = letter -> apply(letter);
        final List<String> tpack8 = pack.stream().filter(st8.apply("a")).collect(Collectors.toList());
        System.out.println(tpack8);
        System.out.println();

        final Function<String, Predicate<String>> st9 = Java8_06_function::apply;
        final List<String> tpack9 = pack.stream().filter(st9.apply("a")).collect(Collectors.toList());
        System.out.println(tpack9);
        System.out.println();

        final Function<String, Predicate<String>> st10 = Java8_06_function::applyVerbose;
        final List<String> tpack10 = pack.stream().filter(st10.apply("a")).collect(Collectors.toList());
        System.out.println(tpack10);
        System.out.println();

        final List<String> tpack11 = lamdaMethod1(pack, st10, "b");
        System.out.println(tpack11);
        System.out.println();

        Predicate<String> predicate = st10.apply("j");
        final List<String> tpack12 = lamdaMethod2(pack, predicate);
        System.out.println(tpack12);
        System.out.println();

        final List<String> tpack13 = lamdaMethod2(pack, st10.apply("j"));
        System.out.println(tpack13);
        System.out.println();
    }

    private static List<String> lamdaMethod1(List<String> pack, Function<String, Predicate<String>> st, String letter)  {
        return pack.stream().filter(st.apply(letter)).collect(Collectors.toList());
    }

    private static List<String> lamdaMethod2(List<String> pack, Predicate<String> st)  {
        return pack.stream().filter(st).collect(Collectors.toList());
    }

    private static Predicate<String> criteria(final String letter) {
        return name->name.startsWith(letter);
    }

    private static Predicate<String> applyVerbose(String letter) {
        Predicate<String> criteria = (String name) -> name.startsWith(letter);
        return criteria;
    }

    private static Predicate<String> apply(String letter) {
        return name -> name.startsWith(letter);
    }
}
