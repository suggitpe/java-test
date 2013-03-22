package org.suggs.test.sandbox.concordion.settlement.support.dsl;

import org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementRequestSender;
import org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementStatusListener;

import static org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementRequestBuilder.aSettlementRequest;

/**
 * This classes responsibility is:
 * 1. To define the key functional interactions with the system under test.
 */
public class DSL {

    // inject me fool!!!!
    private SettlementRequestSender settlementRequestSender = new SettlementRequestSender();
    private SettlementStatusListener settlementStatusListener = new SettlementStatusListener();


    protected SettlementRequest createSettlementRequestForSettlementMethod(String aSettlementMethod) {
        return aSettlementRequest().withASettlementMethodOf(aSettlementMethod).build();
    }

    protected SettlementRequest createSettlementRequestForTradeType(String aTradeType) {
        return aSettlementRequest().withATradeTypeOf(aTradeType).build();
    }

    public SettlementRequest createSettlementRequestForEventType(String aEventType) {
        return aSettlementRequest().withAEventTypeOf(aEventType).build();
    }

    protected void sendSettlementRequest(SettlementRequest aSettlementRequest) {
        settlementRequestSender.sendSettlementRequest(aSettlementRequest);
    }

    protected SettlementRequestStatus waitForSettlementStatus() {
        return settlementStatusListener.listen();
    }
}
