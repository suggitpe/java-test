package org.suggs.test.sandbox.statemachine.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.suggs.test.sandbox.statemachine.State;
import org.suggs.test.sandbox.statemachine.StateMachine;
import org.suggs.test.sandbox.statemachine.StateTransition;
import org.suggs.test.sandbox.statemachine.impl.StateMachineImpl;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionEventImpl;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionImpl;
import org.suggs.test.sandbox.statemachine.support.FalseGuardStub;
import org.suggs.test.sandbox.statemachine.support.TrueGuardStub;

import javax.inject.Inject;

@Configuration
@Import(value = ConnectionStateMachineStatesConfiguration.class)
@ImportResource(value = {"classpath:META-INF/spring/it-state-machine-connection-test-transitions.xml"})
public class ConnectionStateMachineConfiguration {

    @Inject
    public State initialState;
    @Inject
    private State disconnectedState;
    @Inject
    private State connectedState;
    @Inject
    private State connectingState;
    @Inject
    private State failedState;
    @Inject
    private State disconnectingState;

    @Bean
    public StateMachine stateMachine() {
        return new StateMachineImpl(initialState);
    }

    @Bean
    public StateTransition fromInitialToDisconnected() {
        return new StateTransitionImpl("fromInitialToDisconnected", initialState, disconnectedState);
    }

    @Bean
    public StateTransition fromDisconnectedToConnecting() {
        StateTransitionImpl transition = new StateTransitionImpl("fromDisconnectedToConnecting", disconnectedState, connectingState);
        transition.addTransitionEvent(new StateTransitionEventImpl("connect"));
        return transition;
    }

    @Bean
    public StateTransition fromConnectingToConnected() {
        StateTransitionImpl transition = new StateTransitionImpl("fromConnectingToConnected", connectingState, connectedState);
        transition.addTransitionGuard(new TrueGuardStub());
        return transition;
    }

    @Bean
    public StateTransition fromConnectingToFailed() {
        StateTransitionImpl transition = new StateTransitionImpl("fromConnectingToFailed", connectingState, failedState);
        transition.addTransitionGuard(new FalseGuardStub());
        return transition;
    }

    @Bean
    public StateTransition fromFailedToConnecting() {
        return new StateTransitionImpl("fromFailedToConnecting", failedState, connectingState);
    }

    @Bean
    public StateTransition fromConnectedToDisconnecting(){
        StateTransitionImpl transition = new StateTransitionImpl("fromConnectedToDisconnecting", connectedState, disconnectingState);
        transition.addTransitionEvent(new StateTransitionEventImpl("disconnect"));
        return transition;
    }


}


