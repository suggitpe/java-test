package org.suggs.test.sandbox.jbehave.springstatemachineannotated;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.suggs.test.sandbox.statemachine.State;
import org.suggs.test.sandbox.statemachine.StateMachine;
import org.suggs.test.sandbox.statemachine.StateMachineException;
import org.suggs.test.sandbox.statemachine.StateTransitionEvent;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionEventImpl;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.suggs.test.sandbox.jbehave.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;

/**
 * The functional responsibilities of this class are:
 * 1. To join the spring context to the story and facilitate the execution of the JBehave stories.
 */
@Configuration
@ImportResource(value = "classpath:META-INF/spring/it-state-machine-connection-test-statemachine.xml")
public class TraverseStateMachineAnnotatedBehaviour {

    private static final Logger LOG = LoggerFactory.getLogger(TraverseStateMachineAnnotatedBehaviour.class);

    @Test
    public void traverseStateMachine() throws Exception {
        aBehaviouralTestRunner()
                .withIncludedStoriesFoundBy("**/*machine.story")
                .usingStepsConfigurationContextFrom(TraverseStateMachineAnnotatedBehaviour.class)
                .run();
    }

    @Inject
    private StateMachine stateMachine;

    @Resource(name = "stateMap")
    private Map<String, State> stateMap;

    @Given("an unused state machine")
    public void aStateMachineExists() {
        stateMachine.reset();
    }

    @When("no events are received")
    public void noEventsReceived() {
        LOG.debug("Not sending any events at the state manager");
    }

    @When("a $eventType event is received")
    public void aEventIsReceived(@Named("eventType") String eventType) throws StateMachineException {
        LOG.debug("Sending a [" + eventType + "] event to the state machine under test");
        stateMachine.step(createStateMachineContext(eventType));
    }

    @Then("the state should be $stateName")
    public void theStateShouldBe(@Named("stateName") String aStateName) {
        LOG.debug("Checking that the state is [" + aStateName + "]");
        assertThat("In the transition we have ended up in the wrong state.",
                stateMachine.getCurrentState(),
                equalTo(stateMap.get(aStateName)));
    }

    private org.suggs.test.sandbox.statemachine.StateMachineContext createStateMachineContext(final String aEventType) {
        return new org.suggs.test.sandbox.statemachine.StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl(aEventType);
            }
        };
    }

}
