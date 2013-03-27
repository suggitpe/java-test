/*
 * StateTransitionEvent.java created on 1 Sep 2009 19:01:44 by suggitpe for project Libraries - State Machine
 * 
 */
package org.suggs.test.sandbox.statemachine;

/**
 * Interface to encapsulate a state transition event.
 * 
 * @author suggitpe
 * @version 1.0 1 Sep 2009
 */
public interface StateTransitionEvent {

    /**
     * Accessor to the name of the event.
     * 
     * @return the name of the event
     */
    String getEventName();

}
