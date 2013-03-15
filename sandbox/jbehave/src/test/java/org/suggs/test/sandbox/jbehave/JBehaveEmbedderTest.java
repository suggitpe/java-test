package org.suggs.test.sandbox.jbehave;

import org.jbehave.core.annotations.UsingSteps;
import org.suggs.test.sandbox.jbehave.gameoflife.GameOfLifeSteps;
import org.suggs.test.sandbox.jbehave.support.AbstractStoryEmbedder;
import org.suggs.test.sandbox.jbehave.trader.TraderSteps;

/**
 * Class to run the JBehave stories.
 */
@UsingSteps(instances = {GameOfLifeSteps.class, TraderSteps.class})
public class JBehaveEmbedderTest extends AbstractStoryEmbedder {

}
