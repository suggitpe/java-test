package org.suggs.test.sandbox.statemachine.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.suggs.test.sandbox.statemachine.State;
import org.suggs.test.sandbox.statemachine.StateMachine;
import org.suggs.test.sandbox.statemachine.impl.StateImpl;
import org.suggs.test.sandbox.statemachine.impl.StateMachineImpl;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ImportResource(value = {"classpath:META-INF/spring/it-state-machine-connection-test-transitions.xml"})
public class ConnectionStateMachineConfiguration {

    public static final String INITIAL_STATE = "Connection:Initial";
    public static final String DISCONNECTED_STATE = "Connection:Disconnected";
    public static final String CONNECTING_STATE = "Connection:Connecting";
    public static final String CONNECTED_STATE = "Connection:Connected";
    public static final String FAILED_STATE = "Connection:Failed";
    public static final String DISCONNECTING_STATE = "Connection:Disconnecting";

    @Bean
    public StateMachine stateMachine() {
        return new StateMachineImpl(initialState());
    }

    @Bean
    public Map<String, State> stateMap() {
        Map<String, State> stateMap = new HashMap<String, State>();
        stateMap.put("INITIAL", initialState());
        stateMap.put("CONNECTED", connectedState());
        stateMap.put("DISCONNECTED", disconnectedState());
        return stateMap;
    }

    @Bean
    public State initialState() {
        return new StateImpl(INITIAL_STATE);
    }

    @Bean
    public State disconnectedState() {
        return new StateImpl(DISCONNECTED_STATE);
    }

    @Bean
    public State connectingState() {
        return new StateImpl(CONNECTING_STATE);
    }

    @Bean
    public State connectedState() {
        return new StateImpl(CONNECTED_STATE);
    }

    @Bean
    public State failedState() {
        return new StateImpl(FAILED_STATE);
    }

    @Bean
    public State disconnectingState() {
        return new StateImpl(DISCONNECTING_STATE);
    }


}
