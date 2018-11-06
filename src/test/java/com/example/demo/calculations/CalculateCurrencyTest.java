package com.example.demo.calculations;

import com.example.demo.model.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalculateCurrencyTest {

    CurrencyData currencyData = new CurrencyData();
    CalculateCurrency calculateCurrency = new CalculateCurrency();

        @Before
        public void setValues() {

            Rates firstValue = new Rates("EUR", "date", new BigDecimal("4.1943"), new BigDecimal("4.2791"));
            Rates secondValue = new Rates("EUR", "date", new BigDecimal("4.1903"), new BigDecimal("4.2749"));
            Rates thirdValue = new Rates("EUR", "date", new BigDecimal("4.182"), new BigDecimal("4.2664"));
            Rates fourthValue = new Rates("EUR", "date", new BigDecimal("4.1721"), new BigDecimal("4.2563"));
            Rates fifthValue = new Rates("EUR", "date", new BigDecimal("4.1688"), new BigDecimal("4.253"));

            List<Rates> ratesList = Arrays.asList(firstValue, secondValue, thirdValue, fourthValue, fifthValue);
            currencyData.setRatesList(ratesList);
        }

        @Test
        public void getAverage() {
            //when
            BigDecimal averageBid = calculateCurrency.getAverageBidRate(currencyData);
            BigDecimal testValue = new BigDecimal ("4.1815");

            //then
            assertEquals(testValue.stripTrailingZeros(), averageBid.stripTrailingZeros());
        }

        @Test
        public void getStandardDeviation() {
            //when
            BigDecimal deviationAsk = calculateCurrency.getStandardDeviationAsk(currencyData);
            BigDecimal testValue = new BigDecimal ("0.0101");

            //then
            assertEquals(testValue.stripTrailingZeros(), deviationAsk.stripTrailingZeros());
    }
}