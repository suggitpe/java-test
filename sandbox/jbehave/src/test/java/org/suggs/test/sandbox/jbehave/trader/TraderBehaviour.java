package org.suggs.test.sandbox.jbehave.trader;

import org.jbehave.core.annotations.UsingSteps;
import org.suggs.test.sandbox.jbehave.support.AbstractSpringStoryEmbedder;

import java.util.Arrays;
import java.util.List;

/**
 * This classes responsibility is:
 * 1.
 */
@UsingSteps(instances = {TraderSteps.class})
public class TraderBehaviour extends AbstractSpringStoryEmbedder {

    @Override
    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/trader_is_alerted_*.story");
    }
}
