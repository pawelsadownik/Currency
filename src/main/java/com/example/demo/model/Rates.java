package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {


    @JsonProperty("no")
    private String no;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("bid")
    private BigDecimal bid;

    @JsonProperty("ask")
    private BigDecimal ask;

    public Rates() {
    }

    public Rates(String no, String effectiveDate, BigDecimal bid, BigDecimal ask) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }
}
