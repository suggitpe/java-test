/*
 * StateMachineSteps.java created on 7 Sep 2010 18:31:15 by suggitpe for project state-machine-lib
 * 
 */
package org.suggs.test.sandbox.jbehave.springstatemachine;

import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.statemachine.*;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionEventImpl;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unused")
public class StateMachineSteps {

    private static final Logger LOG = LoggerFactory.getLogger(StateMachineSteps.class);

    protected StateMachine stateMachine;

    private Map<String, State> stateMap;

    @BeforeStories
    public void doBeforeStories() {
        LOG.debug("=================== Start: " + TraverseStateMachineBehaviour.class.getSimpleName());
    }

    @AfterStories
    public void doAfterStories() {
        LOG.debug("=================== End: " + TraverseStateMachineBehaviour.class.getSimpleName());
    }

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

    private StateMachineContext createStateMachineContext(final String aEventType) {
        return new StateMachineContext() {

            @Override
            public StateTransitionEvent getStateTransitionEvent() {
                return new StateTransitionEventImpl(aEventType);
            }
        };
    }

    public void setStateMachine(StateMachine aStateMachine) {
        stateMachine = aStateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public Map<String, State> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, State> aStateMap) {
        stateMap = aStateMap;
    }

}
