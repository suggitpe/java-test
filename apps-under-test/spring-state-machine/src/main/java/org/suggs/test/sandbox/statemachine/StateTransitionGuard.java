package org.suggs.test.sandbox.statemachine;

/**
 * State Transition guard to allow for logical evaluation of a state transition occurrance. Based on the
 * execution of the assocated guard logic, the transition would either pass or fail.
 */
public interface StateTransitionGuard {

    /**
     * Execute the evaluation of the guard condition.
     */
    boolean evaluateGuard( StateMachineContext aContext );

}
