package org.suggs.test.sandbox.jbehave.gameoflife;

import org.jbehave.core.annotations.UsingSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suggs.test.sandbox.jbehave.support.AbstractSpringStoryEmbedder;

import java.util.Arrays;
import java.util.List;

/**
 * This classes responsibility is:
 * 1.
 */
@UsingSteps(instances = {GameOfLifeSteps.class})
public class GameOfLifeBehaviour extends AbstractSpringStoryEmbedder {
    private static final Logger LOG = LoggerFactory.getLogger(GameOfLifeBehaviour.class);

    @Override
    protected List<String> doGetStoryIncludeRegex() {
        return Arrays.asList("**/game_of_life_*.story");
    }
}
