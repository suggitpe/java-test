package org.suggs.test.sandbox.concordion.settlement.support.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class SettlementRequestImpl implements SettlementRequest {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementRequestImpl.class);

    private SettlementMethod settlementMethod;
    private TradeType tradeType;

    @Override
    public void setSettlementMethod(SettlementMethod aSettlementMethod) {
        settlementMethod = aSettlementMethod;
    }

    @Override
    public void setTradeType(TradeType aTradeType) {
        tradeType = aTradeType;
    }
}
