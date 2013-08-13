package org.suggs.test.sandbox.statemachine.impl;


import org.suggs.test.sandbox.statemachine.StateTransitionEvent;

/**
 * Simple class to encapsulate an event for a state transition.
 */
@SuppressWarnings("unused")
public class StateTransitionEventImpl implements StateTransitionEvent {

    private final String eventName;

    public StateTransitionEventImpl( String aEventName ) {
        eventName = aEventName;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder( "StateTransitionEventImpl:" );
        buff.append( " eventName=[" ).append( eventName ).append( "]" );
        return buff.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        StateTransitionEventImpl other = (StateTransitionEventImpl) obj;
        if ( eventName == null ) {
            if ( other.eventName != null ) {
                return false;
            }
        }
        else if ( !eventName.equals( other.eventName ) ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( eventName == null ) ? 0 : eventName.hashCode() );
        return result;
    }
}
