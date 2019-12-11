package com.udemy.Java8;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8_12_sorting {
    private static final Logger logger = LogManager.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        List<Person> persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Comparator<Person> comparator1 = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
//                return person1.getAge() - person2.getAge();
                return person1.ageDifference(person2);
            }
        };
        Collections.sort(persons, comparator1);
        System.out.println(persons);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Comparator<Person> comparator2 = (person1, person2) -> {
            return person1.ageDifference(person2);
        };
        Collections.sort(persons, comparator2);
        persons.sort(comparator2);
        System.out.println(persons);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Comparator<Person> comparator3 = (person1, person2) -> person1.ageDifference(person2);
        Collections.sort(persons, comparator3);
        System.out.println(persons);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Comparator<Person> comparator4 = Person::ageDifference;
        Collections.sort(persons, comparator4);
        System.out.println(persons);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("sara", 12)
        );
        System.out.println(persons);

        final List<Person> sorted1 = persons.stream().sorted(comparator4).collect(Collectors.toList());
        System.out.println(sorted1);
        System.out.println();

        final Comparator<Person> comparator5 = (person1, person2) -> person2.ageDifference(person1);
        final List<Person> sorted2 = persons.stream().sorted(comparator5).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted2);
        System.out.println();

        final List<Person> sorted3 = persons.stream().sorted(comparator4.reversed()).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted3);
        System.out.println();

        final Comparator<Person> comparator6 = (person1, person2) -> person1.getAge() - person2.getAge();
        final List<Person> sorted4 = persons.stream().sorted(comparator6.reversed()).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted4);
        System.out.println();

        final Comparator<Person> comparator7 = (person1, person2) -> person1.getName().compareTo(person2.getName());
        final List<Person> sorted6 = persons.stream().sorted(comparator7).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted6);
        System.out.println();

        final Function<Person, String> comparator8 = person -> person.getName();
        final List<Person> sorted7 = persons.stream().sorted(Comparator.comparing(comparator8)).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted7);
        System.out.println();

        final List<Person> sorted8 = persons.stream().sorted(Comparator.comparing(comparator8).reversed()).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted8);
        System.out.println();

        final Function<Person, Integer> comparator9 = person -> (Integer) person.getAge();
        final List<Person> sorted9 = persons.stream().sorted(Comparator.comparing(comparator9)).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted9);
        System.out.println();

        final List<Person> sorted10 = persons.stream().sorted(Comparator.comparing(comparator9).reversed()).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sorted10);
        System.out.println();

        persons = Arrays.asList(
                new Person("alan", 72),
                new Person("michel", 24),
                new Person("jack", 15),
                new Person("bernard", 49),
                new Person("leonard", 79),
                new Person("leonard", 60),
                new Person("sara", 12)
        );
        System.out.println(persons);
        final Function<Person, String> comparator10 = person -> person.getName();
        final Function<Person, Integer> comparator11 = person -> person.getAge();
        final List<Person> sorted11 = persons.stream().sorted(Comparator.comparing(comparator10).thenComparing(comparator11)).collect(Collectors.toList());
        System.out.println(sorted11);
        System.out.println();
    }
}
