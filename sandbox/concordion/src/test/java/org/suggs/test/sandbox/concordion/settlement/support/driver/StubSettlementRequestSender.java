package org.suggs.test.sandbox.concordion.settlement.support.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;

import javax.inject.Named;

/**
 * This classes responsibility is:
 * 1. To stub the settlement request sending function.
 */
@Named
@SuppressWarnings("unused")
public class StubSettlementRequestSender implements SettlementRequestSender {
    private static final Logger LOG = LoggerFactory.getLogger(StubSettlementRequestSender.class);

    @Override
    public void sendSettlementRequest(SettlementRequest aSettlementRequest) {
        LOG.debug("##### Pretend to send a settlement status using some sort of sender");
    }
}
