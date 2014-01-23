package org.suggs.test.sandbox.concordion.settlement.fxsettlement;

import org.agileinsider.concordion.junit.ConcordionPlus;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.DSL;
import org.suggs.test.sandbox.concordion.settlement.fxsettlement.support.dsl.DslSpringContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * This classes responsibility is:
 * 1. to hide the details of Concordion and Spring integration.
 */
@RunWith(ConcordionPlus.class)
public abstract class AbstractFxSettlementFixture {
    protected DSL dsl;

    public AbstractFxSettlementFixture() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DslSpringContext.class);
        dsl = (DSL) ctx.getBean("DSL");
        assertThat(dsl, is(notNullValue()));
    }
}
