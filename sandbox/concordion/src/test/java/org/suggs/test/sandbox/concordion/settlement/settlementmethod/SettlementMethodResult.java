package org.suggs.test.sandbox.concordion.settlement.settlementmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.support.dsl.SettlementStatus;

/**
 * This classes responsibility is:
 * 1.
 */
public class SettlementMethodResult {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementMethodResult.class);

    private boolean cashManaged;
    private boolean accountedFor;
    private boolean settlementRiskManaged;
    private boolean nostroMoved;

    public SettlementMethodResult(SettlementStatus aStatus) {
        cashManaged = aStatus.isCashManaged();
        accountedFor = aStatus.isAccountedFor();
        settlementRiskManaged = aStatus.isSettlementRiskManaged();
        nostroMoved = aStatus.isNostroMoved();
    }

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
