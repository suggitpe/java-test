package org.suggs.test.sandbox.statemachine;

/**
 * Interface to define the behaviour associated with a State. This State interface is to be used in
 * conjunction with the state machine in the same library. Each state should be wholly responsible for
 * managing its overall transition sequences and evaluation each of the transitions that are associated with
 * it.
 */
public interface State {

    String getStateName();

    /**
     * Attempt to perform a state transition.
     */
    State step( StateMachineContext aContext ) throws StateMachineException;

    /**
     * When a statemachine enters a new state, it calls this method on the new state.
     */
    void executeEntryAction( StateMachineContext aContext ) throws StateMachineException;

    /**
     * When a statemachine enters a new state, it calls this method on the old state.
     */
    void executeExitAction( StateMachineContext aContext ) throws StateMachineException;

}
