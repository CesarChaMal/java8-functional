package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java8_16_delegating {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static void main(String[] args) {
        logger.info("Java 8 Functional programming");
        System.out.println();

        final CalculateNAV calculateNAV = new CalculateNAV(AlphAvantage::getPrice);
        System.out.println(String.format("10 shares of Google worth: $%.3f", calculateNAV.computeStockWorth("6006", 10)));
    }
}
