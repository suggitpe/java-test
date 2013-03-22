package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.DSL;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

/**
 * This classes responsibility is:
 * 1. Act as fixture to the settlement method specification
 */
@RunWith(ConcordionPlus.class)
public class SupportDifferentSettlementMethods extends DSL {


    public SettlementRequestStatus processSettlementForSettlementMethodOf(String aSettlementMethod) {
        SettlementRequest request = createSettlementRequestForSettlementMethod(aSettlementMethod);
        sendSettlementRequest(request);
        return waitForSettlementStatus();
    }

}
