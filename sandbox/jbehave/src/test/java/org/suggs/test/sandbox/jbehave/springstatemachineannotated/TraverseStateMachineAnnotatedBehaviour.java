package org.suggs.test.sandbox.jbehave.springstatemachineannotated;

import org.jbehave.core.annotations.spring.UsingSpring;
import org.suggs.test.sandbox.jbehave.support.AbstractSpringStoryEmbedder;

import java.util.Arrays;
import java.util.List;

/**
 * The functional responsibilities of this class are:
 * 1.
 */
@UsingSpring(resources = "org.suggs.test.sandbox.jbehave.springstatemachineannotated.StateMachineContext")
public class TraverseStateMachineAnnotatedBehaviour extends AbstractSpringStoryEmbedder {
    @Override
    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/*machine.story");
    }
}