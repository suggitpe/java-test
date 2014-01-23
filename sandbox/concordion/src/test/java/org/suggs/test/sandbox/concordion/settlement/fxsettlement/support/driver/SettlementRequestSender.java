package org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.driver;

import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1. Send settlement requests.
 */
public interface SettlementRequestSender {

    public void sendSettlementRequest(SettlementRequest aSettlementRequest);
}
