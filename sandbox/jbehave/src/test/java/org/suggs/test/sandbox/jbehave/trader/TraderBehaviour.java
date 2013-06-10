package org.suggs.test.sandbox.jbehave.trader;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.suggs.test.sandbox.trader.Stock;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.suggs.test.sandbox.jbehave.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;

/**
 * This classes responsibility is:
 * 1.
 */
public class TraderBehaviour {

    private Stock stock;

    @Test
    public void traderIsAlertedWithStockPrices() throws Exception {
        aBehaviouralTestRunner()
                .withIncludedStoriesFoundBy("**/trader_is_alerted_*.story")
                .usingStepsFrom(this)
                .run();
    }

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
