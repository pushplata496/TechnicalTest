/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.technicaltest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;

/**
 *
 * @author pushp
 */
public class Data {
     public static Collection<EntityBean> getMemoryData() {
         Collection<EntityBean>  dataInMemory = new ArrayList<EntityBean>();
         dataInMemory.add(new EntityBean("Entity1", BuySell.BUY, new BigDecimal("0.50"), Currency.getInstance("GBP"), LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 3), new BigDecimal("200"), new BigDecimal("100.25")));
         dataInMemory.add(new EntityBean("Entity2", BuySell.SELL, new BigDecimal("0.51"), Currency.getInstance("SGD"), LocalDate.of(2017, 10, 2), LocalDate.of(2017, 10, 4), new BigDecimal("201"), new BigDecimal("101.26")));
         dataInMemory.add(new EntityBean("Entity3", BuySell.BUY, new BigDecimal("0.50"), Currency.getInstance("AUD"), LocalDate.of(2017, 10, 3), LocalDate.of(2017, 10, 3), new BigDecimal("200"), new BigDecimal("100.25")));
         dataInMemory.add(new EntityBean("Entity4", BuySell.SELL, new BigDecimal("0.53"), Currency.getInstance("INR"), LocalDate.of(2017, 10, 4), LocalDate.of(2017, 10, 6), new BigDecimal("203"), new BigDecimal("103.28")));
         dataInMemory.add(new EntityBean("Entity5", BuySell.BUY, new BigDecimal("0.54"), Currency.getInstance("AED"), LocalDate.of(2017, 10, 5), LocalDate.of(2017, 10, 7), new BigDecimal("204"), new BigDecimal("104.29")));
         dataInMemory.add(new EntityBean("Entity6", BuySell.SELL, new BigDecimal("0.55"), Currency.getInstance("GBP"), LocalDate.of(2017, 10, 6), LocalDate.of(2017, 10, 17), new BigDecimal("205"), new BigDecimal("105.30")));
         dataInMemory.add(new EntityBean("Entity7", BuySell.BUY, new BigDecimal("0.56"), Currency.getInstance("SAR"), LocalDate.of(2017, 10, 7), LocalDate.of(2017, 10, 17), new BigDecimal("206"), new BigDecimal("106.31")));
         dataInMemory.add(new EntityBean("Entity8", BuySell.SELL, new BigDecimal("0.58"), Currency.getInstance("USD"), LocalDate.of(2017, 10, 8), LocalDate.of(2017, 10, 22), new BigDecimal("207"), new BigDecimal("00000")));
         
         

         
         
         
         return dataInMemory;
}
}