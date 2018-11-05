package com.example.demo.calculations;

import com.example.demo.model.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalculateCurrencyTest {


    @Test
    public void getAverage() {

        //given
        CurrencyData currencyData = new CurrencyData();

        Rates firstValue = new Rates();
        Rates secondValue = new Rates();
        Rates thirdValue = new Rates();
        Rates fourthValue = new Rates();
        Rates fifthValue = new Rates();

        firstValue.setBid(new BigDecimal("4.1943"));
        secondValue.setBid(new BigDecimal("4.1903"));
        thirdValue.setBid(new BigDecimal("4.182"));
        fourthValue.setBid(new BigDecimal("4.1721"));
        fifthValue.setBid(new BigDecimal("4.1688"));

        firstValue.setAsk(new BigDecimal("4.2791"));
        secondValue.setAsk(new BigDecimal("4.2749"));
        thirdValue.setAsk(new BigDecimal("4.2664"));
        fourthValue.setAsk(new BigDecimal("4.2563"));
        fifthValue.setAsk(new BigDecimal("4.253"));

        List<Rates> ratesList = Arrays.asList(firstValue, secondValue, thirdValue, fourthValue, fifthValue);

        currencyData.setRatesList(ratesList);

        //when
        CalculateCurrency calculateCurrency = new CalculateCurrency();

        BigDecimal averageBid = calculateCurrency.getAverageBidRate(currencyData);
        BigDecimal deviationAsk = calculateCurrency.getStandardDeviationAsk(currencyData);

        //then
        assertTrue(averageBid.equals("4.1815"));
        assertTrue(deviationAsk.equals(0.0101));


    }

}