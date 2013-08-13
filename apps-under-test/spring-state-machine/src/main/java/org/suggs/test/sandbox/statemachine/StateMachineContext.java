package org.suggs.test.sandbox.statemachine;

/**
 * This is the main context for the state machine and allows an encapsulated data structure to be passed
 * around the state machine library. This context should contain all of the information that the state machine
 * needs to evaluate whether or not to transition from one state to another.
 */
public interface StateMachineContext {

    /**
     * Getter for the state transition event
     */
    StateTransitionEvent getStateTransitionEvent();

}
