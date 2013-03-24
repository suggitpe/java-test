package org.suggs.test.sandbox.concordion.settlement.support.driver;

import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

/**
 * This interfaces responsibility is:
 * 1. Listen for status messages from the obligation manager.
 */
public interface SettlementStatusListener {

    public SettlementRequestStatus listen();
}
