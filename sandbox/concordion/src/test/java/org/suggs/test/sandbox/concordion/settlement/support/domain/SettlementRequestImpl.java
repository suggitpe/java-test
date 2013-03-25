package org.suggs.test.sandbox.concordion.settlement.support.domain;

import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1. POJO to represent the underlying settlement request.
 */
public class SettlementRequestImpl implements SettlementRequest {

    private SettlementMethod settlementMethod;
    private TradeType tradeType;
    private EventType eventType;

    @Override
    public void setSettlementMethod(SettlementMethod aSettlementMethod) {
        settlementMethod = aSettlementMethod;
    }

    @Override
    public void setTradeType(TradeType aTradeType) {
        tradeType = aTradeType;
    }

    @Override
    public void setEventType(EventType aEventType) {
        eventType = aEventType;
    }
}
