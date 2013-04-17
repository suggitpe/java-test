package org.suggs.test.sandbox.jbehave.springstatemachineannotated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * The functional responsibilities of this class are:
 * 1.
 */
@Configuration
@ImportResource(value = "classpath:META-INF/spring/state-machine-steps.xml")
public class StateMachineContext {
    private static final Logger LOG = LoggerFactory.getLogger(StateMachineContext.class);
}
