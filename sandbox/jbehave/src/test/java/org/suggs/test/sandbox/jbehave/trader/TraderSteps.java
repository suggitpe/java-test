package org.suggs.test.sandbox.jbehave.trader;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.suggs.test.sandbox.trader.Stock;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Steps class to support the Trader story.
 */
public class TraderSteps {

    private Stock stock;

    @Given("a stock with a symbol of <symbol>")
    public void givenAStockWithASymbolOf(@Named("symbol") String aSymbolName) {
        stock = new Stock();
        stock.setStockName(aSymbolName);
    }

    @Given("a threshold of <threshold>")
    public void givenAThresholdOf(@Named("threshold") Double aThreshold) {
        stock.setThreshold(aThreshold);
    }

    @When("the stock is traded at <price>")
    public void whenTheStockIsTradedAt(@Named("price") Double aPrice) {
        stock.tradeAt(aPrice);
    }

    @Then("the alert status should be <status>")
    public void thenTheAlertStatusShouldBe(@Named("status") String aStatus) {
        assertThat(stock.getStatus(), equalTo(Stock.STATUS.valueOf(aStatus)));
    }


}
