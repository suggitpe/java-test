/*
 * StateTransitionTest.java created on 1 Sep 2009 07:20:51 by suggitpe for project Libraries - State Machine
 * 
 */
package org.suggs.test.sandbox.statemachine;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.statemachine.impl.StateImpl;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionEventImpl;
import org.suggs.test.sandbox.statemachine.impl.StateTransitionImpl;
import org.suggs.test.sandbox.statemachine.support.FalseGuardStub;
import org.suggs.test.sandbox.statemachine.support.TrueGuardStub;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test suite for the state transition implementation.
 *
 * @author suggitpe
 * @version 1.0 1 Sep 2009
 */
public class StateTransitionTest {

    private static final Logger LOG = LoggerFactory.getLogger( StateTransitionTest.class );

    private State startState;
    private State endState;
    private StateMachineContext context;

    /** */
    @BeforeClass
    public static void doBeforeClass() {
        LOG.debug( "===================" + StateTransitionTest.class.getSimpleName() );
    }

    /** */
    @Before
    public void doBefore() {
        LOG.debug( "------------------- " );
        startState = mock( State.class );
        endState = mock( State.class );
        context = mock( StateMachineContext.class );
    }

    /**
     * Simply tests that the attributes of the transition set at the time of the construction are correctly kept
     * throughout.
     */
    @Test
    public void transitionDataSetisSameWhenGetLater() {
        final String transName = "TestStateTransition";
        State localStartState = new StateImpl( "TestStartState" );
        State localendState = new StateImpl( "TestEndState" );
        StateTransition transition = new StateTransitionImpl( transName, localStartState, localendState );

        assertThat( localStartState, equalTo( transition.getStartingState() ) );
        assertThat( localendState, equalTo( transition.getEndingState() ) );
        assertThat( transName, equalTo( transition.getTransitionName() ) );

        LOG.debug( "Verified that the objects set at construction are correctly persisted into the object" );
    }

    @SuppressWarnings("boxing")
    @Test
    public void hashcodeWorksForSameObjectContents() {
        StateTransitionImpl trans1a = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1b = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState" ) );
        assertThat( trans1a.hashCode(), equalTo( trans1b.hashCode() ) );
    }

    @SuppressWarnings("boxing")
    @Test
    public void hashcodeFailsForifferentObjectContents() {
        StateTransitionImpl trans1a = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1b = new StateTransitionImpl( "stateTransition2",
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1c = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState1" ),
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1d = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState1" ) );
        StateTransitionImpl trans1e = new StateTransitionImpl( null,
                new StateImpl( "testStartState" ),
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1f = new StateTransitionImpl( "stateTransition1",
                null,
                new StateImpl( "testEndState" ) );
        StateTransitionImpl trans1g = new StateTransitionImpl( "stateTransition1",
                new StateImpl( "testStartState" ),
                null );
        trans1g.setTransitionEvents( null );
        trans1g.setTransitionGuards( null );
        assertThat( trans1b.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
        assertThat( trans1c.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
        assertThat( trans1d.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
        assertThat( trans1e.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
        assertThat( trans1f.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
        assertThat( trans1g.hashCode(), not( equalTo( trans1a.hashCode() ) ) );
    }

    /**
     * Tests the that the equals, hashcode and toString methods work correctly
     */
    @Test
    public void equalsWorksWithDefaultValues() {
        StateImpl state1a = new StateImpl( "startState1" );
        StateImpl state1b = new StateImpl( "startState1" );
        StateImpl state2 = new StateImpl( "startState2" );

        StateImpl endState1a = new StateImpl( "endState1" );
        StateImpl endState1b = new StateImpl( "endState1" );
        StateImpl endState2 = new StateImpl( "endState2" );

        StateTransitionImpl trans1a = new StateTransitionImpl( "stateTransition1", state1a, endState1a );
        StateTransitionImpl trans1b = new StateTransitionImpl( "stateTransition1", state1b, endState1b );
        StateTransitionImpl trans2 = new StateTransitionImpl( "stateTransition2", state2, endState2 );

        // check equals method
        assertThat( trans1a, not( sameInstance( trans1b ) ) );
        assertThat( trans1a, not( sameInstance( trans2 ) ) );
        assertThat( trans1a, equalTo( trans1b ) );
        assertThat( trans1a, not( equalTo( trans2 ) ) );

        assertThat( trans1a, notNullValue() );
        assertThat( trans1a, instanceOf( StateTransition.class ) );
        assertTrue( trans1a.equals( trans1a ) );

        LOG.debug( "StateTransition1a: " + trans1a );
        LOG.debug( "StateTransition2: " + trans2 );
    }

    @Test
    public void equalsIsFalseUnderNullFieldsFromOneSide() {
        StateImpl state1 = new StateImpl( "startState1" );
        StateImpl state2 = new StateImpl( "startState2" );

        assertThat( new StateTransitionImpl( "test1", state1, state2 ),
                equalTo( new StateTransitionImpl( "test1", state1, state2 ) ) );

        // test equals for null
        assertThat( new StateTransitionImpl( "test1", state1, state2 ),
                not( equalTo( new StateTransitionImpl( "test1", state1, null ) ) ) );
        assertThat( new StateTransitionImpl( "test1", state1, state2 ),
                not( equalTo( new StateTransitionImpl( "test1", null, state2 ) ) ) );
        assertThat( new StateTransitionImpl( "test1", state1, state2 ),
                not( equalTo( new StateTransitionImpl( null, state1, state2 ) ) ) );
    }

    @Test
    public void equalsFailsUnderDifferentValues() {
        StateImpl state1 = new StateImpl( "startState1" );
        StateImpl state2 = new StateImpl( "startState2" );

        // test equals for diff states
        assertThat( new StateTransitionImpl( "test1", state1, state2 ),
                not( equalTo( new StateTransitionImpl( "test1", state2, state2 ) ) ) );
        assertThat( new StateTransitionImpl( "test2", state1, state2 ),
                not( equalTo( new StateTransitionImpl( "test1", state2, state2 ) ) ) );

        assertThat( new StateTransitionImpl( "test2", state1, state2 ),
                not( equalTo( new StateTransitionImpl( "test1", state1, state2 ) ) ) );

        StateTransitionImpl test = new StateTransitionImpl( "test1", state1, state2 );
        test.setTransitionEvents( null );
        assertThat( test, not( equalTo( new StateTransitionImpl( "test1", state1, state2 ) ) ) );
        assertThat( new StateTransitionImpl( "test1", state1, state2 ), not( equalTo( test ) ) );

        test = new StateTransitionImpl( "test1", state1, state2 );
        test.setTransitionGuards( null );
        assertThat( test, not( equalTo( new StateTransitionImpl( "test1", state1, state2 ) ) ) );
        assertThat( new StateTransitionImpl( "test1", state1, state2 ), not( equalTo( test ) ) );
    }

    /**
     * Tests that when a null context is passed into the evaluation method, that an exception is thrown.
     *
     * @throws StateMachineException from the evaluation call. We expect that an exception is thrown during the
     *                               execution of this test.
     */
    @Test(expected = StateMachineException.class)
    public void transitionEvaluationForNullContext() throws StateMachineException {
        StateTransition target = new StateTransitionImpl( "testTransition", startState, endState );

        LOG.debug( "Calling evaluate on the transition to endure that it throws an exception" );
        target.evaluateTransitionValidity( null );

        fail( "The test should have thrown an execption so this should not be seen" );
    }

    /**
     * Tests that when an event context with a matching transition event is passed into the transition, it will state
     * that the transition is valid.
     *
     * @throws StateMachineException this should not happen for this test
     */
    @SuppressWarnings("boxing")
    @Test
    public void tranitionEventEvaluationForValidEvent() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        StateTransitionEvent evt = new StateTransitionEventImpl( "testEvent" );
        target.addTransitionEvent( evt );

        when( context.getStateTransitionEvent() ).thenReturn( new StateTransitionEventImpl( "testEvent" ) );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For the valid event [" + evt + "] we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

    /**
     * Tests that when a state transition is evaluated with no events that it will evaluate to true.
     *
     * @throws StateMachineException this should not happen for this test
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNoEvents() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );

        StateTransitionEvent evt = new StateTransitionEventImpl( "testEvent" );

        when( context.getStateTransitionEvent() ).thenReturn( evt );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For no set transition events we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

    /**
     * Tests that when a state transition has events that do not match with the context event that it will return false
     *
     * @throws StateMachineException this should not happen for this test
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNoValidEvents() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        StateTransitionEvent evt = new StateTransitionEventImpl( "testEvent" );
        target.addTransitionEvent( evt );

        when( context.getStateTransitionEvent() ).thenReturn( new StateTransitionEventImpl( "notMatchingEvent" ) );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For the invalid event [" + evt + "] we are expecting false and we got [" + result + "]" );

        assertThat( result, is( false ) );
    }

    /**
     * Tests that if the event collection on the state transition is null then we return true (similar to no events)
     *
     * @throws StateMachineException this should not happen for this test
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNullEvents() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        target.setTransitionEvents( null );

        when( context.getStateTransitionEvent() ).thenReturn( new StateTransitionEventImpl( "notMatchingEvent" ) );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For transition events we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

    /**
     * Tests that when we evaluate a state transition with a valid guard that it evaluates to true.
     *
     * @throws StateMachineException when evaluating the transaction validity
     *
     */
    @SuppressWarnings("boxing")
    @Test
    public void tranitionEventEvaluationForValidGuard() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        target.addTransitionGuard( new TrueGuardStub() );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For transition guards we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

    /**
     * Tests that when we evaluate a state transition with one valid guard and one invalid guard that it evaluates
     * false.
     *
     * @throws StateMachineException when evaluating the transition validity
     */
    @SuppressWarnings("boxing")
    @Test
    public void tranitionEventEvaluationForValidGuardAndInvalidGuard() throws StateMachineException {
        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        target.addTransitionGuard( new FalseGuardStub() );
        target.addTransitionGuard( new TrueGuardStub() );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For transition guards we are expecting false and we got [" + result + "]" );
        assertThat( result, is( false ) );
    }

    /**
     * Tests that if we evaluiate a state transition with no guards that it evaluates to true
     *
     * @throws StateMachineException when evaluating the transition validity
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNoGuards() throws StateMachineException {

        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For no transition guards we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

    /**
     * Tests that when we evaluate a state transition with only invalid guards that it evaluates to false
     *
     * @throws StateMachineException when evaluating the transition validity
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNoValidGuards() throws StateMachineException {

        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        target.addTransitionGuard( new FalseGuardStub() );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For no valid transition guards we are expecting false and we got [" + result + "]" );
        assertThat( result, is( false ) );
    }

    /**
     * Tests that when the guard collection is null that we return true
     *
     * @throws StateMachineException when evaluating the transition validity
     */
    @SuppressWarnings("boxing")
    @Test
    public void transitionEventEvaluationForNullGuards() throws StateMachineException {

        StateTransitionImpl target = new StateTransitionImpl( "testTransition", startState, endState );
        target.setTransitionGuards( null );

        boolean result = target.evaluateTransitionValidity( context );
        LOG.debug( "For null transition guards we are expecting true and we got [" + result + "]" );
        assertThat( result, is( true ) );
    }

}
