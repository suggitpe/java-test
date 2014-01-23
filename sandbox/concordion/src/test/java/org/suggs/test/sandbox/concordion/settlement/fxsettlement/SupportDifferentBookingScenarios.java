package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequest;


/**
 * This classes responsibility is:
 * 1. Fixture class for the booking scenarios specification
 */
public class SupportDifferentBookingScenarios extends AbstractFxSettlementFixture {

    public String processSettlementForEventTypeOf(String aEventType) {
        SettlementRequest request = dsl.createSettlementRequestForEventType(aEventType);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus().isSettlementComplete()?aEventType:"Failed to process settlement";
    }
}
