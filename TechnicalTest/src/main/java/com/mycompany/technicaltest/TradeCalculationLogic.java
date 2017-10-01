/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.technicaltest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author pushp
 */
public class TradeCalculationLogic {

    public static Collection<EntityBean> getIncomingOutgoingBean(Collection<EntityBean> bean, BuySell bs) {
        Collection<EntityBean> buySellBean = new ArrayList();
        if(bean!=null && !bean.isEmpty()){
        bean.stream().filter((b) -> (bs.equals(b.getBuySell()))).forEachOrdered((b) -> {
            buySellBean.add(b);
        });}
        return buySellBean;
    }
    
    /**
     *
     * @param bean
     * @return
     */
    public static Collection<LocalDate> getSettelemetDates(Collection<EntityBean> bean) {
        
        Collection<LocalDate> settlementDate = new ArrayList();
        if(bean!=null){
        bean.stream().filter((b) -> (!settlementDate.contains(getActualSettlementDate(b)))).forEachOrdered((b) -> {
            settlementDate.add(getActualSettlementDate(b));
        });}
        return settlementDate;
    }

    /**
     *
     * @param bean
     * @param dates
     * @return
     */
    public static Map<LocalDate, BigDecimal> getSettledIncomingOutGoingAmount(Collection<EntityBean> bean, Collection<LocalDate> dates) {
        Map<LocalDate, BigDecimal> settledIncomingOutgoing = new TreeMap<>();
if(bean!=null && dates!=null){
        dates.forEach((date) -> {
            BigDecimal settledIncoming = BigDecimal.ZERO;
            for (EntityBean b : bean) {

                if (getActualSettlementDate(b).equals(date)) {
                    settledIncoming = settledIncoming.add(b.getSettledAmount()).setScale(2, RoundingMode.CEILING);
                }
            }
            settledIncomingOutgoing.put(date, settledIncoming);
        });}
        return settledIncomingOutgoing;

    }

    /**
     *
     * @param b
     * @return
     */
    private static LocalDate getActualSettlementDate(EntityBean b) {

        LocalDate actualSettlementDate = b.getSettlementDate();

        if (Currency.getInstance("AED").equals(b.getCurrency()) || Currency.getInstance("SAR").equals(b.getCurrency())) {
            switch (b.getSettlementDate().getDayOfWeek()) {
                case SATURDAY:
                    actualSettlementDate = actualSettlementDate.plusDays(1);
                    break;
                case FRIDAY:
                    actualSettlementDate = actualSettlementDate.plusDays(2);
                    break;
                default:
                    break;
            }
        } else {
            switch (b.getSettlementDate().getDayOfWeek()) {
                case SATURDAY:
                    actualSettlementDate = actualSettlementDate.plusDays(2);
                    break;
                case SUNDAY:
                    actualSettlementDate = actualSettlementDate.plusDays(1);
                    break;
                default:
                    break;
            }
        }

        return actualSettlementDate;
    }

    public static void getSettledBuyReport(Map<LocalDate, BigDecimal> buydata) {
        System.out.println("\n\n<---- Buy repor (Amount round as ceiling with two decimal value)----->\n\n");
        System.out.println("Date               SettledAmount");
        System.out.println("--------------------------------");
        buydata.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + "               " + entry.getValue());
        });

    }

    public static void getSettledSellReport(Map<LocalDate, BigDecimal> selldata) {
        System.out.println("\n\n<---- Sell report (Amount round as ceiling with two decimal value)----->\n\n");
        System.out.println("Date               SettledAmount");
        System.out.println("--------------------------------");
        selldata.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + "               " + entry.getValue());
        });
    }

    public static void getIncomingRanking(Collection<EntityBean> b) {
        List<EntityBean> resultInComingRanking = getRanking(b);
        System.out.println("\n\n<----Incoming Entity Ranking ----->\n\n");
        System.out.println("Rank               EntityName");
        System.out.println("--------------------------------");
        resultInComingRanking.forEach((bean) -> {
            System.out.println(bean.getEntity() + "               " + bean.getRank());
        });
    }

    /**
     *
     * @param b
     */
    public static void getOutgoingRanking(Collection<EntityBean> b) {
        List<EntityBean> resultOutGoingRanking = getRanking(b);
        System.out.println("\n\n<----OuntGoing Entity Ranking ----->\n\n");
        System.out.println("Rank               EntityName");
        System.out.println("--------------------------------");
        resultOutGoingRanking.forEach((bean) -> {
            System.out.println(bean.getEntity() + "               " + bean.getRank());
        });
    }

    private static List getRanking(Collection<EntityBean> b) {
        List<EntityBean> beanList= new ArrayList<>();
        if(b!=null){
         beanList= new ArrayList(b);
        Collections.sort(beanList, (EntityBean o1, EntityBean o2) -> o1.getSettledAmount().compareTo(o2.getSettledAmount()));
        List<BigDecimal> p = beanList.stream().map(a -> a.getSettledAmount()).distinct().collect(Collectors.toList());
        beanList.forEach(a -> a.setRank(p.indexOf(a.getSettledAmount()) + 1));
        }
        return beanList;
    }

}
