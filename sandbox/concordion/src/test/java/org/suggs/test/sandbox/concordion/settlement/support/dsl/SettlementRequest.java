package org.suggs.test.sandbox.concordion.settlement.support.dsl;

import org.suggs.test.sandbox.concordion.settlement.support.domain.SettlementMethod;
import org.suggs.test.sandbox.concordion.settlement.support.domain.TradeType;

/**
 * This interfaces responsibility is:
 * 1.
 */
public interface SettlementRequest {

    void setSettlementMethod(SettlementMethod aSettlementMethod);

    void setTradeType(TradeType aTradeType);
}
