package org.suggs.test.sandbox.jbehave.springstatemachine;

import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.suggs.test.sandbox.jbehave.support.AbstractSpringStoryEmbedder;

import java.util.Arrays;
import java.util.List;

/**
 * This classes responsibility is:
 * 1.
 */
@UsingSpring(resources = {"classpath:META-INF/spring/state-machine-steps.xml"})
@UsingSteps(instances = {StateMachineSteps.class})
public class TraverseStateMachineBehaviour extends AbstractSpringStoryEmbedder {

    @Override
    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/*machine.story");
    }
}
