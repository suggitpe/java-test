package org.suggs.test.sandbox.concordion.settlement.supportedtradetypes;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This classes responsibility is:
 * 1. Fixture class for the supported trade types specification
 */
@RunWith(ConcordionPlus.class)
public class SupportedTradeTypes {
    private static final Logger LOG = LoggerFactory.getLogger(SupportedTradeTypes.class);

    public boolean processSettlementForTradeTypeOf(String aTradeType) {
        return true;
    }
}
