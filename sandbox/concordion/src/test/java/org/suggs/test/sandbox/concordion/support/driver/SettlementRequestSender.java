package org.suggs.test.sandbox.concordion.support.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.support.dsl.SettlementRequest;

/**
 * This classes responsibility is:
 * 1.
 */
public class SettlementRequestSender {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementRequestSender.class);

    public void sendSettlementRequest(SettlementRequest aSettlementRequest) {
        LOG.debug("##### Pretend to send a settlement status using some sort of sender");
    }
}
