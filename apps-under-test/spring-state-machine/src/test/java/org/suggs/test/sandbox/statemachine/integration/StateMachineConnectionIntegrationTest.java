/*
 * StateMachineConnectionIntegrationTest.java created on 3 Sep 2009 20:14:30 by suggitpe for project Libraries - State Machine
 * 
 */
package org.suggs.test.sandbox.statemachine.integration;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.suggs.test.sandbox.statemachine.*;
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
@ContextConfiguration(locations = {"classpath:META-INF/spring/it-state-machine-connection-test-statemachine.xml"})
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

    @Test
    public void initialisationOfStateMachineThroughSpring() throws StateMachineException {
        LOG.info("Testing that we can initialise the state machine through Spring ... sanity check");
        State initial = stateMachine.getCurrentState();
        LOG.debug("Injected state machine: " + stateMachine);
        assertThat(initial, equalTo(initialState));
    }

    @Test
    public void transitionFromInitialToDisconnected() throws StateMachineException {
        LOG.info("Checking that with any event we will transition from Initial to Disconnected");
        State initial = stateMachine.getCurrentState();
        assertThat(initial, equalTo(initialState));

        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("DumyEvent for initial test");
            }
        });

        State newState = stateMachine.getCurrentState();
        assertThat(newState, equalTo(disconnectedState));
        LOG.debug("Verified that the state machine has correctly transitioned to the Disconnected State");
    }

    @Test
    public void transitionFromDisconnectedToConnected() throws StateMachineException {
        LOG.info("Checking that when we pass in a connect event that we transition through the connecting state and onto the connected state");
        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("connect");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(connectedState));
    }

    @Test
    public void transitionFromConnectedToDisconnected() throws StateMachineException {
        LOG.info("Checking that when we pass in a disconnect event that we transition through the disconnecting state and onto the disconnected state");
        assertThat(stateMachine.getCurrentState(), equalTo(connectedState));
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("disconnect");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
    }

    @Test
    @Ignore
    public void noTransitionOccursFromIrrelevantEvent() throws StateMachineException {
        LOG.info("Checking that if we pass in a totally random event we stay in the same overall state");
        assertThat(stateMachine.getCurrentState(), equalTo(initialState));
        stateMachine.step(new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl("notRelevantEvent");
            }
        });
        assertThat(stateMachine.getCurrentState(), equalTo(disconnectedState));
    }
}
