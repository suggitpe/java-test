package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequestStatus;

/**
 * This classes responsibility is:
 * 1. Act as fixture to the settlement method specification
 */
public class SupportDifferentSettlementMethods extends AbstractFxSettlementFixture {

    public SettlementRequestStatus processSettlementForSettlementMethodOf(String aSettlementMethod) {
        SettlementRequest request = dsl.createSettlementRequestForSettlementMethod(aSettlementMethod);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus();
    }

}
