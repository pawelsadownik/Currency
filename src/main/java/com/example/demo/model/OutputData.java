package com.example.demo.model;

import java.math.BigDecimal;

public class OutputData {


    private BigDecimal averageBidRate;
    private BigDecimal standardDeviationBid;
    private BigDecimal averageAskRate;
    private BigDecimal standardDeviationAsk;

    public BigDecimal getAverageBidRate() {
        return averageBidRate;
    }

    public void setAverageBidRate(BigDecimal averageBidRate) {
        this.averageBidRate = averageBidRate;
    }

    public BigDecimal getStandardDeviationBid() {
        return standardDeviationBid;
    }

    public void setStandardDeviationBid(BigDecimal standardDeviationBid) {
        this.standardDeviationBid = standardDeviationBid;
    }

    public BigDecimal getAverageAskRate() {
        return averageAskRate;
    }

    public void setAverageAskRate(BigDecimal averageAskRate) {
        this.averageAskRate = averageAskRate;
    }

    public BigDecimal getStandardDeviationAsk() {
        return standardDeviationAsk;
    }

    public void setStandardDeviationAsk(BigDecimal standardDeviationAsk) {
        this.standardDeviationAsk = standardDeviationAsk;
    }

}
