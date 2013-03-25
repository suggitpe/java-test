package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

/**
 * This classes responsibility is:
 * 1. Fixture class for the supported trade types specification
 */

public class SupportDifferentTradeTypes extends AbstractFxSettlementFixture {
    public SettlementRequestStatus processSettlementForTradeTypeOf(String aTradeType) {
        SettlementRequest request = dsl.createSettlementRequestForTradeType(aTradeType);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus();
    }
}
