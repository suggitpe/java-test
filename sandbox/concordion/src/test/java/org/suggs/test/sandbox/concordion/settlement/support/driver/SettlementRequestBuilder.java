package org.suggs.test.sandbox.concordion.settlement.support.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.domain.SettlementMethod;
import org.suggs.test.sandbox.concordion.settlement.support.domain.SettlementRequestImpl;
import org.suggs.test.sandbox.concordion.settlement.support.domain.TradeType;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class SettlementRequestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementRequestBuilder.class);

    private SettlementMethod settlementMethod;
    private TradeType tradeType;

    public static SettlementRequestBuilder aSettlementRequest() {
        return new SettlementRequestBuilder();
    }

    public SettlementRequest build() {
        SettlementRequest request = new SettlementRequestImpl();

        request.setSettlementMethod(settlementMethod);
        request.setTradeType(tradeType);

        return request;
    }

    public SettlementRequestBuilder withASettlementMethodOf(String aSettlementMethod) {
        settlementMethod = SettlementMethod.fromString(aSettlementMethod);
        return this;
    }

    public SettlementRequestBuilder withATradeTypeOf(String aTradeType) {
        tradeType = TradeType.fromString(aTradeType);
        return this;
    }
}
