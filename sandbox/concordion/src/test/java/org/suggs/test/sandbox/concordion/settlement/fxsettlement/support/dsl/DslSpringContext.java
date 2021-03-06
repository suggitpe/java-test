package org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This classes responsibility is:
 * 1. to manage spring integration/injection for the tests
 */
@Configuration
@ComponentScan(basePackages = "org.suggs.test.sandbox.concordion.settlement.fxsettlement")
public class DslSpringContext {

}
