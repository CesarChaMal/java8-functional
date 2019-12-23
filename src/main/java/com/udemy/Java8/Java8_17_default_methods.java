package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java8_17_default_methods {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");

        Vehicle vehicle = new Car();
        vehicle.print();

        System.out.println();
    }
}

interface Vehicle {
    default void print() {
        System.out.println("I am a vehicle!");
    }

    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}


