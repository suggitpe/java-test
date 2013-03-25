package org.suggs.test.sandbox.concordion.settlement.support.dsl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This classes responsibility is:
 * 1.
 */
@Configuration
@ComponentScan(basePackages = "org.suggs.test.sandbox.concordion.settlement")
public class DslSpringContext {
    private static final Logger LOG = LoggerFactory.getLogger(DslSpringContext.class);

}
