package org.suggs.test.sandbox.concordion.settlement.settlementmethod;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This classes responsibility is:
 * 1. Act as fixture to the settlement method specification
 */
@RunWith(ConcordionPlus.class)
public class SettlementMethod {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementMethod.class);

    public SettlementMethodTestResult processSettlementForSettlementMethodOf(String aSettlementMethod) {
        return new SettlementMethodTestResult(false, true, false , false);
    }

    private class SettlementMethodTestResult {

        public SettlementMethodTestResult(boolean isCashManaged, boolean isAccountedFor, boolean isRiskmanaged, boolean isNostroMoved) {
            cashManaged = isCashManaged;
            accountedFor = isAccountedFor;
            settlementRiskManaged = isRiskmanaged;
            nostroMoved = isNostroMoved;
        }

        private boolean cashManaged;
        private boolean accountedFor;
        private boolean settlementRiskManaged;
        private boolean nostroMoved;

        public boolean isCashManaged() {
            return cashManaged;
        }

        public boolean isAccountedFor() {
            return accountedFor;
        }

        public boolean isRiskManaged() {
            return settlementRiskManaged;
        }

        public boolean isNostroMoved() {
            return nostroMoved;
        }
    }
}
