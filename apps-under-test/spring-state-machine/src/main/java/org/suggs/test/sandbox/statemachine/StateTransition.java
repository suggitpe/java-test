package org.suggs.test.sandbox.statemachine;

/**
 * Interface to define the behaviour associated with a transition between two states. This transition is to be
 * used in conjunction with a state in the same library. Each state transition will be responsible for
 * managing the logic of determining whether it is itself valid for transition.
 */
public interface StateTransition {

    String getTransitionName();

    State getStartingState();

    State getEndingState();

    /**
     * This is the core delegation method on the transitions. It is here that a transition evaluates itself
     * for validity against the passed in context.
     */
    boolean evaluateTransitionValidity(StateMachineContext aContext) throws StateMachineException;

}
