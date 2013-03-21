package org.suggs.test.sandbox.concordion.support.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.support.domain.SettlementMethod;
import org.suggs.test.sandbox.concordion.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class SettlementRequestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementRequestBuilder.class);

    private SettlementMethod settlementMethod;

    public static SettlementRequestBuilder aSettlementRequest() {
        return new SettlementRequestBuilder();
    }

    public SettlementRequest build() {
        SettlementRequest request = new SettlementRequestImpl();

        request.setSettlementMethod(settlementMethod);

        return request;
    }

    public SettlementRequestBuilder withASettlementMethodOf(String aSettlementMethod) {
        settlementMethod = SettlementMethod.fromString(aSettlementMethod);
        return this;
    }
}
