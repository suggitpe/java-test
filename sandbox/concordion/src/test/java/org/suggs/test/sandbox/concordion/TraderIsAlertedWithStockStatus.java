package org.suggs.test.sandbox.concordion;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.trader.Stock;

/**
 * Concordion fixture class.
 */
@RunWith(ConcordionPlus.class)
public class TraderIsAlertedWithStockStatus {

    private static final Logger LOG = LoggerFactory.getLogger(TraderIsAlertedWithStockStatus.class);

    public String checkStockStatusFrom(String aSymbolName, Double aThreshold, Double aPrice) {
        Stock stock = new Stock(aSymbolName, aThreshold);
        stock.tradeAt(aPrice);
        return stock.getStatus().toString();
    }

}
