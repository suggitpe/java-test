/*
 * StateMachineConnectionIntegrationTest.java created on 3 Sep 2009 20:14:30 by suggitpe for project Libraries - State Machine
 * 
 */
package org.suggs.test.sandbox.statemachine.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.suggs.test.sandbox.statemachine.*;
import org.suggs.test.sandbox.statemachine.impl.StateMachineImpl;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionEventImpl;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Integration test that uses a spring injected state machine to replicate how the state machine library can
 * be used to navigate your way through a state machine. In this test we use the example of a simple
 * connection to show how the navigation process works.
 *
 * @author suggitpe
 * @version 1.0 3 Sep 2009
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConnectionStateMachineConfiguration.class)
public class StateMachineConnectionIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(StateMachineConnectionIntegrationTest.class);

    @Inject
    protected StateMachine stateMachine;

    @Inject
    protected State disconnectedState;

    @Inject
    protected State initialState;

    @Inject
    protected State connectedState;

    @Before
    public void resetStateMachine() {
        resetStateMachineToStateOf(initialState);
    }

    @Test
    public void areInitialisedToAnInitialState() throws StateMachineException {
        assertThat(stateMachine.getCurrentState(), equalTo(initialState));
    }

    @Test
    public void willInitillyTransitionToDisconnectedStateWithInvalidEvent() throws StateMachineException {
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("DumyEvent for initial test");
            }
        });

        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
    }

    @Test
    public void willTransitionToConnectedWithConnectEvent() throws StateMachineException {
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("connect");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(connectedState));
    }

    @Test
    public void willTransitionFromConnectedToDisconnected() throws StateMachineException {
        resetStateMachineToStateOf(connectedState);

        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("disconnect");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
    }

    @Test
    public void willIgnoreIrrelevntEvents() throws StateMachineException {
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("notRelevantEvent");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
    }

    private void resetStateMachineToStateOf(State aNewState) {
        ((StateMachineImpl) stateMachine).setCurrentState(aNewState);
    }
}
