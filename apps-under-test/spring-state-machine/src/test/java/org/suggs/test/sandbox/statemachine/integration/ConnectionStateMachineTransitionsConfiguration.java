package org.suggs.test.sandbox.statemachine.integration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:META-INF/spring/it-state-machine-connection-test-transitions.xml"})
public class ConnectionStateMachineTransitionsConfiguration {
}
