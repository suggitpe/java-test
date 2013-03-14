package org.suggs.test.sandbox.jbehave.gameoflife;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.suggs.test.sandbox.gameoflife.GameOfLife;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Steps class to support the game of life process.
 */
public class GameOfLifeSteps {

    private GameOfLife gameOfLife;

    @Given("a $columns by $rows game")
    public void givenAGridGameOfSize(int columns, int rows) {
        gameOfLife = new GameOfLife(columns, rows);
    }

    @When("I toggle the cell at ($column, $row)")
    public void whenIToggleTheCellAt(int column, int row) {
        gameOfLife.toggleCellAt(column, row);
    }

    @Then("the grid should look like $grid")
    public void thenTheGridShouldLookLikeX(String grid) {
        assertThat(gameOfLife.toString(), equalTo(grid));
    }


}
