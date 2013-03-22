package org.suggs.test.sandbox.concordion.settlement.support.domain;

public enum EventType {
    NEW("New"),
    AMEND("Amend"),
    CANCEL("Cancel");

    private final String eventType;

    private EventType(String aEventType) {
        eventType = aEventType;
    }

    public static EventType fromString(String aEnumText) {
        if (aEnumText != null) {
            for (EventType eventType : EventType.values()) {
                if (aEnumText.equals(eventType.eventType)) {
                    return eventType;
                }
            }
        }
        return null;
    }
}
