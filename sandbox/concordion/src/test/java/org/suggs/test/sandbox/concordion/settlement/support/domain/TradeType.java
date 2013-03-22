package org.suggs.test.sandbox.concordion.settlement.support.domain;

/**
 * This classes responsibility is:
 * 1.
 */
public enum TradeType {
    FX_SPOT("FX;Spot"),
    FX_FORWARD("FX:Fwd"),
    FX_SWAP("FX:Swap"),
    FX_NDS("FX:NDS"),
    FX_NDF("FX:NDF");

    private final String tradeType;

    private TradeType(String aTradeType) {
        tradeType = aTradeType;
    }

    public static TradeType fromString(String aEnumText) {
        if (aEnumText != null) {
            for (TradeType tradeType : TradeType.values()) {
                if (aEnumText.equals(tradeType.tradeType)) {
                    return tradeType;
                }
            }
        }
        return null;
    }
}
