package org.suggs.test.sandbox.concordion.support.dsl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.suggs.test.sandbox.concordion.support.driver.SettlementRequestBuilder.aSettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class DSL {
    private static final Logger LOG = LoggerFactory.getLogger(DSL.class);

    protected SettlementStatus waitForSettlementStatus() {
        throw new IllegalStateException();
    }

    protected void sendSettlementRequest(SettlementRequest settlementRequestForMethod) {
        throw new IllegalStateException();
    }

    protected SettlementRequest createSettlementRequestForMethod(String aSettlementMethod) {
        return aSettlementRequest().withASettlementMethodOf(aSettlementMethod).build();
    }
}
