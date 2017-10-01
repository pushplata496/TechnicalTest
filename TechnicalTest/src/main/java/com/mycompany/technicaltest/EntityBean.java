/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.technicaltest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

/**
 *
 * @author pushp
 */
class EntityBean {

    public EntityBean(String entity, BuySell buySell, BigDecimal agreedFX, Currency currency, LocalDate  instructionDate, LocalDate  settlementDate, BigDecimal units, BigDecimal pricePerUnit) {
        this.buySell = buySell;
        this.agreedFX = agreedFX;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
        this.entity=entity;
    }
    private BuySell buySell;

    public BuySell getBuySell() {
        return buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public BigDecimal getAgreedFX() {
        return agreedFX;
    }

    public void setAgreedFX(BigDecimal agreedFX) {
        this.agreedFX = agreedFX;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate  getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(LocalDate  instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate  getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate  settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    private String entity;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
        private BigDecimal agreedFX;  
        private Currency currency;  
        private LocalDate  instructionDate;
        private LocalDate  settlementDate;
        private BigDecimal units;
        private BigDecimal pricePerUnit;
         private Integer rank;
         private BigDecimal settledAmount;

    public BigDecimal getSettledAmount() {
        settledAmount=agreedFX.multiply(units.multiply(pricePerUnit));
        return settledAmount;
    }

    public void setSettledAmount(BigDecimal settledAmount) {
        this.settledAmount = settledAmount;
    }

    public EntityBean(String entity, Integer rank) {
        this.entity = entity;
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
        
}
