package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.DSL;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.DslSpringContext;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequest;
import org.suggs.test.sandbox.concordion.settlement.support.dsl.SettlementRequestStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * This classes responsibility is:
 * 1. Fixture class for the booking scenarios specification
 */
@RunWith(ConcordionPlus.class)
public class SupportDifferentBookingScenarios {
    private static final Logger LOG = LoggerFactory.getLogger(SupportDifferentBookingScenarios.class);

    private DSL dsl;

    public SupportDifferentBookingScenarios() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DslSpringContext.class);
        dsl = (DSL) ctx.getBean("DSL");
        assertThat(dsl, is(notNullValue()));
    }

    public SettlementRequestStatus processSettlementForEventTypeOf(String aEventType) {
        SettlementRequest request = dsl.createSettlementRequestForEventType(aEventType);
        dsl.sendSettlementRequest(request);
        return dsl.waitForSettlementStatus();
    }
}
