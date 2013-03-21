package org.suggs.test.sandbox.concordion.settlement.settlementmethod;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.support.dsl.DSL;
import org.suggs.test.sandbox.concordion.support.dsl.SettlementStatus;

/**
 * This classes responsibility is:
 * 1. Act as fixture to the settlement method specification
 */
@RunWith(ConcordionPlus.class)
public class SettlementMethod extends DSL {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementMethod.class);

    public SettlementMethodResult processSettlementForSettlementMethodOf(String aSettlementMethod) {
        LOG.info("Settling with method of [" + aSettlementMethod + "]");
        sendSettlementRequest(createSettlementRequestForMethod(aSettlementMethod));
        SettlementStatus status = waitForSettlementStatus();
        return new SettlementMethodResult(status);
    }

}
