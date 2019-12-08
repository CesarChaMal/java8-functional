package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8_13_collect {
    private static final Logger logger = LogManager.getLogger("Java8");

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        List<Person> persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("leonard", 60),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Function<Person, String> byName = person -> person.getName();
        final Function<Person, Integer> byAge = person -> person.getAge();
        final List<Person> sorted1 = persons.stream().sorted(Comparator.comparing(byName).thenComparing(byAge)).collect(Collectors.toList());
        System.out.println(sorted1);
        System.out.println();

        System.out.println(persons);
        final List<Person> sorted2 = persons.stream().sorted(Comparator.comparing(byName).thenComparing(byAge)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(sorted2);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("leonard", 60),
                new Person("sara", 12),
                new Person("sara", 60),
                new Person("cesar", 60)
        );
        System.out.println(persons);
        final Map<Integer, List<Person>> sorted3 = persons.stream().sorted(Comparator.comparing(byName).thenComparing(byAge)).collect(Collectors.groupingBy(byAge));
        System.out.println(sorted3);
        System.out.println();

        System.out.println(persons);
        final Map<Integer, List<String>> sorted4 = persons.stream().collect(Collectors.groupingBy(byAge, Collectors.mapping(byName, Collectors.toList())));
        System.out.println(sorted4);
        System.out.println();

        System.out.println(persons);
        final Map<Character, Optional<Person>> sorted5 = persons.stream().collect(Collectors.groupingBy(
                    person -> person.getName().charAt(0), Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(byAge)))
                )
        );
        System.out.println(sorted5);
        System.out.println();

    }
}
