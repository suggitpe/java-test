package org.suggs.test.sandbox.statemachine;

/**
 * Exception to be used within the context of the state machine library.
 */
public class StateMachineException extends Exception {

    private static final long serialVersionUID = 4459635647407776489L;

    /**
     * Constructs a new instance.
     */
    public StateMachineException( String aMsg ) {
        super( aMsg );
    }

}
