package org.suggs.test.sandbox.cucumber.gameoflife;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.suggs.test.sandbox.gameoflife.GameOfLife;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeStepdefs {

    private GameOfLife gameOfLife;

    @Given("^a (\\d+) by (\\d+) game$")
    public void a_by_game(int aWidth, int aHeight) throws Throwable {
        gameOfLife = new GameOfLife(aWidth, aHeight);
    }

    @When("^I toggle the cell at \\((\\d+), (\\d+)\\)$")
    public void I_toggle_the_cell_at_(int aColumn, int aRow) throws Throwable {
        gameOfLife.toggleCellAt(aColumn, aRow);
    }


    @Then("^the grid should look like$")
    public void the_grid_should_look_like(String aExpectedGrid) {
        assertThat(gameOfLife.toString(), is(aExpectedGrid));
    }
}
