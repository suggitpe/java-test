package org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.SettlementRequestStatus;


/**
 * This classes responsibility is:
 * 1. POJO to hold the status of a settlement request
 */
public class SettlementRequestStatusImpl implements SettlementRequestStatus {
    private static final Logger LOG = LoggerFactory.getLogger(SettlementRequestStatusImpl.class);

    private boolean complete = true;
    private boolean cashManaged;
    private boolean accountedFor;
    private boolean settlementRiskManaged;
    private boolean nostroMoved;

    public SettlementRequestStatusImpl(boolean isCashManaged,
                                       boolean isAccountedFor,
                                       boolean isSettlementRiskManaged,
                                       boolean isNotroMoved) {
        cashManaged = isCashManaged;
        accountedFor = isAccountedFor;
        settlementRiskManaged = isSettlementRiskManaged;
        nostroMoved = isNotroMoved;
    }

    @Override
    public boolean isSettlementComplete() {
        return complete;
    }

    public void setSettlementComplete(boolean isComplete) {
        complete = isComplete;
    }

    @Override
    public boolean isCashManaged() {
        return cashManaged;
    }

    public void setCashManaged(boolean isCashManaged) {
        cashManaged = isCashManaged;
    }

    @Override
    public boolean isAccountedFor() {
        return accountedFor;
    }

    public void setAccountedFor(boolean isAccountedFor) {
        accountedFor = isAccountedFor;
    }

    @Override
    public boolean isSettlementRiskManaged() {
        return settlementRiskManaged;
    }

    public void setSettlementRiskManaged(boolean isSettlementRiskManaged) {
        settlementRiskManaged = isSettlementRiskManaged;
    }

    @Override
    public boolean isNostroMoved() {
        return nostroMoved;
    }

    public void setNostroMoved(boolean nostroMoved) {
        this.nostroMoved = nostroMoved;
    }
}
