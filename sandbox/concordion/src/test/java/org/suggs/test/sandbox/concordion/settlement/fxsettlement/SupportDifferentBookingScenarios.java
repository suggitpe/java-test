package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.DSL;


/**
 * This classes responsibility is:
 * 1. Fixture class for the booking scenarios specification
 */
@RunWith(ConcordionPlus.class)
public class SupportDifferentBookingScenarios extends DSL {
    private static final Logger LOG = LoggerFactory.getLogger(SupportDifferentBookingScenarios.class);

    public void processSettlement(String aSettlementStatus) {
    }

}
