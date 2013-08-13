package org.suggs.test.sandbox.statemachine;

/**
 * This interface provides the high level functionality to clients of the state machine, so that they can
 * transition through the state machine for a configured set of states. State transitions are initiated
 * through calls to the step function that will evaluate the event context against the internals of the state
 * machine. A state transition will occur based on the current internal state and the event context that is
 * passed through into the state machine.
 */
public interface StateMachine {

    /**
     * Accessor to the current internal state.
     */
    State getCurrentState();

    /**
     * This method is the core way in which to transition through the state machine. By calling step with the
     * appropriate event context, one can navigate through the state machine effectively.
     */
    void step( StateMachineContext aContext ) throws StateMachineException;

    /**
     * Resets the state machine back to its default position (entry state).
     */
    void reset();

}
