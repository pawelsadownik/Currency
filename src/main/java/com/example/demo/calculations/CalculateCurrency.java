package com.example.demo.calculations;

import com.example.demo.model.CurrencyData;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateCurrency {

    public BigDecimal getAverageBidRate(CurrencyData currencyData) {

        BigDecimal size = new BigDecimal(currencyData.getRatesList().size());
        BigDecimal sumBid = BigDecimal.ZERO;

        for (int i = 0; i < size.intValue(); i++) {
            sumBid = sumBid.add(currencyData.getRatesList().get(i).getBid());
        }

        return sumBid.divide(size, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageAskRate(CurrencyData currencyData) {

        BigDecimal size = new BigDecimal(currencyData.getRatesList().size());
        BigDecimal sumAsk = BigDecimal.ZERO;

        for (int i = 0; i < size.intValue(); i++) {
            sumAsk = sumAsk.add(currencyData.getRatesList().get(i).getAsk());
        }
        return sumAsk.divide(size, 4, RoundingMode.HALF_UP);
    }



    public BigDecimal getStandardDeviationAsk(CurrencyData currencyData) {

        BigDecimal size = new BigDecimal(currencyData.getRatesList().size());
        BigDecimal sumAsk = BigDecimal.ZERO;
        BigDecimal standardDeviationAsk = BigDecimal.ZERO;

        for (int i = 0; i < size.intValue(); i++) {
            sumAsk = sumAsk.add(currencyData.getRatesList().get(i).getAsk());
        }

        for (int i = 0; i < size.intValue(); i++) {
            BigDecimal resultAsk = currencyData.getRatesList().get(i).getAsk().subtract(getAverageAskRate(currencyData));
            standardDeviationAsk = standardDeviationAsk.add(resultAsk.pow(2));
        }

        return new BigDecimal(StrictMath.sqrt(standardDeviationAsk.divide(size, 4, RoundingMode.HALF_UP).doubleValue())).setScale(4, RoundingMode.HALF_UP);
    }

}
