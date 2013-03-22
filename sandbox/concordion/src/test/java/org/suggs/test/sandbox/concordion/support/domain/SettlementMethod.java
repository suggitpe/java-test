package org.suggs.test.sandbox.concordion.support.domain;

/**
 * This classes responsibility is:
 * 1.
 */
public enum SettlementMethod {
    ACCOUNT_TO_ACCOUNT("Account to Account"),
    CONTRACTUAL("Contractual"),
    ACTUAL("Actual");

    private final String settlementMethod;

    private SettlementMethod(String aSettlementMethod) {
        settlementMethod = aSettlementMethod;
    }

    public static SettlementMethod fromString(String aEnumText) {
        if (aEnumText != null) {
            for (SettlementMethod settlementmethod : SettlementMethod.values()) {
                if (aEnumText.equals(settlementmethod.settlementMethod)) {
                    return settlementmethod;
                }
            }
        }
        return null;
    }
}
