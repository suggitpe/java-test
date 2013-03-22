package org.suggs.test.sandbox.concordion.support.dsl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.support.driver.SettlementRequestSender;
import org.suggs.test.sandbox.concordion.support.driver.SettlementStatusListener;

import static org.suggs.test.sandbox.concordion.support.driver.SettlementRequestBuilder.aSettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class DSL {
    private static final Logger LOG = LoggerFactory.getLogger(DSL.class);

    // inject me fool!!!!
    private SettlementRequestSender settlementRequestSender = new SettlementRequestSender();
    private SettlementStatusListener settlementStatusListener = new SettlementStatusListener();


    protected SettlementRequest createSettlementRequestForSettlementMethod(String aSettlementMethod) {
        return aSettlementRequest().withASettlementMethodOf(aSettlementMethod).build();
    }

    protected void sendSettlementRequest(SettlementRequest aSettlementRequest) {
        settlementRequestSender.sendSettlementRequest(aSettlementRequest);
    }

    protected SettlementRequestStatus waitForSettlementStatus() {
        return settlementStatusListener.listen();
    }
}
