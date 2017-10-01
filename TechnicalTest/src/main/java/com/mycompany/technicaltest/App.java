package com.mycompany.technicaltest;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 * Generate a unique number
 *
 */
public class App {

    public static void main(String[] args) {
        Collection<EntityBean> assumedData = null;
        try {
            assumedData = Data.getMemoryData();
        } 
        catch ( IllegalArgumentException | DateTimeException   el) {
            System.out.println("Please enter valid Value  . No result will be displayed  " + el);
            throw el;}
//               
        
        
//       for(EntityBean ld:TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY)){
//            System.out.println("\n\n\n buy bean==="+ld.getEntity() + "date "+ TradeCalculationLogic.getActualSettlementDate(ld));
//        }
//       for(EntityBean ld:TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL)){
//            System.out.println("\n\n\n sell bean==="+ld.getEntity()+ "date "+ TradeCalculationLogic.getActualSettlementDate(ld));
//        }
////       
////       System.out.println("\n\n SELL bean : " + TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL));
////       
//        System.out.println("Incoming settlement dates : " + TradeCalculationLogic.getSettelemetDates(assumedData));
//        for(LocalDate ld:TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY))){
//            System.out.println("\n\n\n date==="+ld);
//        }
//        System.out.println("outgoing settlement dates : " + TradeCalculationLogic.getSettelemetDates(assumedData));
//        for(LocalDate ld:TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL))){
//            System.out.println("\n\n\n date==="+ld);
//        }
//        
//        System.out.println("outgoing settlement dates hash map: " + TradeCalculationLogic.getSettledIncomingOutGoing(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY), TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY))));
//        System.out.println("outgoing settlement dates hash map: " + TradeCalculationLogic.getSettledIncomingOutGoing(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL), TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL))));
//        
        Collection<EntityBean> onlyBuyBean = TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY);
        Collection<LocalDate> buySettlementdates = TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY));
        Map<LocalDate, BigDecimal> buyResult = TradeCalculationLogic.getSettledIncomingOutGoingAmount(onlyBuyBean, buySettlementdates);

        Collection<EntityBean> onlySellBean = TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL);
        Collection<LocalDate> sellSettlementdates = TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.SELL));
        Map<LocalDate, BigDecimal> sellResult = TradeCalculationLogic.getSettledIncomingOutGoingAmount(onlySellBean, sellSettlementdates);

        TradeCalculationLogic.getSettledBuyReport(buyResult);
        TradeCalculationLogic.getSettledSellReport(sellResult);
        TradeCalculationLogic.getOutgoingRanking(onlyBuyBean);
        TradeCalculationLogic.getIncomingRanking(onlySellBean);
//        TradeCalculationLogic.getSettledBuyReport(
//                TradeCalculationLogic.getSettledIncomingOutGoing(
//                        TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY), TradeCalculationLogic.getSettelemetDates(TradeCalculationLogic.getIncomingOutgoingBean(assumedData, BuySell.BUY))));
    }

}
