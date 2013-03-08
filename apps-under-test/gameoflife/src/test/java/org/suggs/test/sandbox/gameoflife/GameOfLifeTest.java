package org.suggs.test.sandbox.gameoflife;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class GameOfLifeTest {
    private static final Logger LOG = LoggerFactory.getLogger(GameOfLifeTest.class);

    @Test
    public void shouldCreateGrid() {
        GameOfLife gameOfLife = new GameOfLife(1, 1);
        assertThat(gameOfLife.toString(), is("."));
    }
}
