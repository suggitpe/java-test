package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1. Fixture class for the supported trade types specification
 */

public class SupportDifferentTradeTypes extends AbstractFxSettlementFixture {

    /**
     * Test fixture will either return the name of the trade type or it will give a default failure notice.
     */
    public String processSettlementForTradeTypeOf(String aTradeType) {
        SettlementRequest request = dsl.createSettlementRequestForTradeType(aTradeType);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus().isSettlementComplete() ? aTradeType : "Failed to process settlement";
    }

}
