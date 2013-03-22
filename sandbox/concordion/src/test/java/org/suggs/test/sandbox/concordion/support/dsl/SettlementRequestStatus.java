package org.suggs.test.sandbox.concordion.support.dsl;

/**
 * This interfaces responsibility is:
 * 1. To convey to interested parties the status of a particular settlement request.
 */
public interface SettlementRequestStatus {

    boolean isSettlementComplete();

    boolean isCashManaged();

    boolean isAccountedFor();

    boolean isSettlementRiskManaged();

    boolean isNostroMoved();
}
