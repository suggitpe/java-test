package org.suggs.test.sandbox.concordion.settlement.securitiessettlement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossCurrencyFlow extends AbstractSecuritiesSettlementFixture {

    private static final Logger LOG = LoggerFactory.getLogger(CrossCurrencyFlow.class);

    public void createBookingReportsWith(String flowType, Integer quantity, String currency) {
        LOG.debug("Creating a {} for {} {}", flowType, currency, quantity);
    }


}
