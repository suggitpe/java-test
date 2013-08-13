package org.suggs.test.sandbox.statemachine;

/**
 * Interface that will allow arbitrary functionality to be called throughout the statemachine implementation.
 * 
 * @author suggitpe
 * @version 1.0 18 Feb 2010
 */
public interface Action {

    /**
     * This interface imposes a vague notion of the command/strategy pattern that can be called to perform
     * some action.
     * 
     * @param aContext
     *            a context object that olds all of the information and references required for successful
     *            execution of the state machine.
     * @throws StateMachineException
     *             when there is any kind of issue caused in the execution of the action.
     */
    void execute( StateMachineContext aContext ) throws StateMachineException;

}
