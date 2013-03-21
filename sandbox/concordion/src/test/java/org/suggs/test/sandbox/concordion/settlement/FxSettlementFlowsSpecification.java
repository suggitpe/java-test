package org.suggs.test.sandbox.concordion.settlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fixture class for the FX Settlement flows.
 */
@RunWith(ConcordionPlus.class)
public class FxSettlementFlowsSpecification {

    private static final Logger LOG = LoggerFactory.getLogger(FxSettlementFlowsSpecification.class);

    public SettlementMethodTestResult processSettlementForSettlementMethodOf(String aSettlementMethod) {
        return new SettlementMethodTestResult(false, false, false, false);
    }

    public void processSettlement(String aSettlementStatus) {
    }

    public void processSettlementForTradeTypeOf(String aTradeType) {

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
