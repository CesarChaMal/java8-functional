package com.udemy.Java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class AlphAvantage {
    private static final Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getEnclosingClass());

    public static BigDecimal getPrice(final String ticker) {
        try {
            final URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=XO6VEMVAYNCRVSWD&datatype=csv?s=" + ticker);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().collect(Collectors.toList()).toString();
            final String[] dataItems = data.split(",");
            DecimalFormat decimalFormat = getDecimalFormat(3);
            String dataExtracted = dataItems[18].split(":")[1].replace("\"", "").trim();
            logger.info("Data extracted from AlphAvantage: " + dataExtracted);
//            BigDecimal formatedBigDecimal = new BigDecimal(decimalFormat.format(new BigDecimal(dataExtracted)));
//            BigDecimal formatedBigDecimal = BigDecimal.valueOf(Double.parseDouble(dataExtracted));
            BigDecimal formatedBigDecimal = getFormatedBigDecimal(decimalFormat, dataExtracted);
            logger.info("Data extracted from AlphAvantage formated: " + formatedBigDecimal);
            return formatedBigDecimal;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static BigDecimal getFormatedBigDecimal(DecimalFormat decimalFormat, String dataExtracted) {
        return new BigDecimal(decimalFormat.format(new BigDecimal(dataExtracted)));
    }

    private static DecimalFormat getDecimalFormat(int decimals) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(decimals);
        decimalFormat.setMinimumFractionDigits(decimals);
        decimalFormat.setGroupingUsed(false);
        return decimalFormat;
    }
}
