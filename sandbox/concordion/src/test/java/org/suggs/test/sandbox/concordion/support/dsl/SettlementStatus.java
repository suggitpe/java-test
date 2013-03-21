package org.suggs.test.sandbox.concordion.support.dsl;

/**
 * This interfaces responsibility is:
 * 1.
 */
public interface SettlementStatus {

    boolean isCashManaged();

    boolean isAccountedFor();

    boolean isSettlementRiskManaged();

    boolean isNostroMoved();
}
