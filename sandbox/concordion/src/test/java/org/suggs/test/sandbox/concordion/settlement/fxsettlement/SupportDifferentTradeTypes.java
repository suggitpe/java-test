package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.DSL;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

/**
 * This classes responsibility is:
 * 1. Fixture class for the supported trade types specification
 */
@RunWith(ConcordionPlus.class)
public class SupportDifferentTradeTypes extends DSL {
    private static final Logger LOG = LoggerFactory.getLogger(SupportDifferentTradeTypes.class);

    public SettlementRequestStatus processSettlementForTradeTypeOf(String aTradeType) {
        SettlementRequest request = createSettlementRequestForTradeType(aTradeType);
        sendSettlementRequest(request);
        return waitForSettlementStatus();
    }
}
