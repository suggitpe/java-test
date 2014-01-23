package org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.domain;

public enum TradeType {
    FX_SPOT("FX:Spot"),
    FX_FORWARD("FX:Forward"),
    FX_SWAP("FX:Swap"),
    FX_NDS("FX:NonDeliverableSpot"),
    FX_NDF("FX:NonDeliverableForward");

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
        throw new IllegalStateException("Trying to process unsupported trade type [" + aEnumText + "]");
    }
}
