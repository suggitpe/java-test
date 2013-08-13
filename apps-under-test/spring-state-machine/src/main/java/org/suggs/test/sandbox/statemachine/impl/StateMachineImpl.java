package org.suggs.test.sandbox.statemachine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.statemachine.State;
import org.suggs.test.sandbox.statemachine.StateMachine;
import org.suggs.test.sandbox.statemachine.StateMachineContext;
import org.suggs.test.sandbox.statemachine.StateMachineException;

/**
 * Implementation of the StateMachine interface. This implementation will delegate all transition evaluation
 * to the underlying current state. Thus the core responsibility of this class is to manage the overall state
 * of the state machine.
 */
public class StateMachineImpl implements StateMachine {

    private static final Logger LOG = LoggerFactory.getLogger( StateMachineImpl.class );

    private State initialState;
    private State currentState;

    public StateMachineImpl( State aInitialState ) {
        initialise( aInitialState );
    }

    private void initialise( State aInitialState ) {
        initialState = aInitialState;
        currentState = aInitialState;
    }

    /**
     * This method delegates down to the underlying current state to perform the state transition evaluation.
     * If we get a new state back from that delegating call, then we update our internal state to reflect
     * this.
     */
    @Override
    public void step( StateMachineContext aContext ) throws StateMachineException {
        State newState = currentState.step( aContext );
        if ( newState == null || currentState.equals( newState ) ) {
            if ( LOG.isInfoEnabled() ) {
                LOG.info( "No valid transitions found from state=[" + currentState
                          + "], state remain unchanged." );
            }
        }
        else {
            if ( LOG.isInfoEnabled() ) {
                LOG.info( "Transitioning state machine to new state=[" + newState + "]" );
            }
            currentState.executeExitAction( aContext );
            currentState = newState;
            currentState.executeEntryAction( aContext );
            // this may look odd: we need to call step again when we
            // reach a new state to allow for transitory states within
            // the overall state machine.
            this.step( aContext );
        }
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState( State aState ) {
        currentState = aState;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder( "StateMachineImpl:" );
        buff.append( " currentState=[" ).append( currentState ).append( "]" );
        return buff.toString();
    }

    @Override
    public void reset() {
        LOG.debug( "Resetting state machine" );
        currentState = initialState;
    }
}
