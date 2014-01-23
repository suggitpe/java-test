package org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl;

import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.domain.EventType;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.domain.SettlementMethod;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.domain.TradeType;

/**
 * This interfaces responsibility is:
 * 1. Provide interaction behaviours to the settlement request from the test
 */
public interface SettlementRequest {

    void setSettlementMethod(SettlementMethod aSettlementMethod);

    void setTradeType(TradeType aTradeType);

    void setEventType(EventType eventType);
}
