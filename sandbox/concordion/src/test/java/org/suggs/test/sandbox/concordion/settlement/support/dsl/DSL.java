package org.suggs.test.sandbox.concordion.settlement.support.dsl;

import org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementRequestSender;
import org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementStatusListener;

import javax.inject.Inject;
import javax.inject.Named;

import static org.suggs.test.sandbox.concordion.settlement.support.driver.SettlementRequestBuilder.aSettlementRequest;

/**
 * This classes responsibility is:
 * 1. To define the key functional interactions with the system under test.
 */
@Named("DSL")
public class DSL {

    @Inject
    private SettlementRequestSender settlementRequestSender;

    @Inject
    private SettlementStatusListener settlementStatusListener;


    public SettlementRequest createSettlementRequestForSettlementMethod(String aSettlementMethod) {
        return aSettlementRequest().withASettlementMethodOf(aSettlementMethod).build();
    }

    public SettlementRequest createSettlementRequestForTradeType(String aTradeType) {
        return aSettlementRequest().withATradeTypeOf(aTradeType).build();
    }

    public SettlementRequest createSettlementRequestForEventType(String aEventType) {
        return aSettlementRequest().withAEventTypeOf(aEventType).build();
    }

    public void sendSettlementRequest(SettlementRequest aSettlementRequest) {
        settlementRequestSender.sendSettlementRequest(aSettlementRequest);
    }

    public SettlementRequestStatus waitForSettlementStatus() {
        return settlementStatusListener.listen();
    }
}
