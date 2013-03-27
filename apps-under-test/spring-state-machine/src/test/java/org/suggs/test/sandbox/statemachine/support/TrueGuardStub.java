/*
 * TrueGuardStub.java created on 3 Sep 2009 19:50:26 by suggitpe for project Libraries - State Machine
 * 
 */
package org.suggs.test.sandbox.statemachine.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.statemachine.StateMachineContext;
import org.suggs.test.sandbox.statemachine.StateTransitionGuard;

/**
 * Stub implementation of the state transition guard that always returns true
 * 
 * @author suggitpe
 * @version 1.0 3 Sep 2009
 */
public class TrueGuardStub implements StateTransitionGuard {

    private static final Logger LOG = LoggerFactory.getLogger( TrueGuardStub.class );

    /**
     * @see org.suggs.test.sandbox.statemachine.StateTransitionGuard#evaluateGuard(org.suggs.test.sandbox.statemachine.StateMachineContext)
     */
    @Override
    public boolean evaluateGuard( StateMachineContext aContext ) {
        LOG.debug( "Executing stub implementation of the evaluateGuard that always returns true" );
        return true;
    }
}
