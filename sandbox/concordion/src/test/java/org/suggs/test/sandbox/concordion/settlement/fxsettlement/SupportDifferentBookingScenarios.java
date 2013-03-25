package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;


/**
 * This classes responsibility is:
 * 1. Fixture class for the booking scenarios specification
 */
public class SupportDifferentBookingScenarios extends AbstractFxSettlementFixture {

    public SettlementRequestStatus processSettlementForEventTypeOf(String aEventType) {
        SettlementRequest request = dsl.createSettlementRequestForEventType(aEventType);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus();
    }
}
