package org.suggs.test.sandbox.jbehave.springstatemachineannotated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.suggs.test.sandbox.jbehave.springstatemachine.StateMachineSteps;
import org.suggs.test.sandbox.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The functional responsibilities of this class are:
 * 1.
 */
@Configuration
@ImportResource(value = "classpath:META-INF/spring/it-state-machine-connection-test-statemachine.xml")
public class StateMachineContext {
    private static final Logger LOG = LoggerFactory.getLogger(StateMachineContext.class);

    @Bean
    public StateMachineSteps myThingIReallyNeed(){
        return new StateMachineSteps();
    }
}
