package org.suggs.test.sandbox.concordion.settlement.support.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.domain.SettlementRequestStatusImpl;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

/**
 * This classes responsibility is:
 * 1. Listen for status messages from the obligation manager.
 */
public class SettlementStatusListener {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementStatusListener.class);

    public SettlementRequestStatus listen() {
        LOG.debug("##### Pretending to listen for messages from the obligation manager and updating the status as we go");
        return new SettlementRequestStatusImpl(false, true, false, false);
    }
}