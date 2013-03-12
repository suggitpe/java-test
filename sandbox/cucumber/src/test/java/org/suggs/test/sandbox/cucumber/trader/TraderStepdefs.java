package org.suggs.test.sandbox.cucumber.trader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.suggs.test.sandbox.trader.Stock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.suggs.test.sandbox.trader.Stock.STATUS.valueOf;

public class TraderStepdefs {

    private Stock stock = new Stock();

    @Given("^a stock of (.+)$")
    public void a_stock_of(String aStockSymbol) throws Throwable {
        stock.setStockName(aStockSymbol);
    }

    @Given("^a threshold of (.+)$")
    public void a_threshold_of(double aThreshold) throws Throwable {
        stock.setThreshold(aThreshold);
    }

    @When("^the stock is traded with (.+)$")
    public void the_stock_is_traded_with_(double aPrice) throws Throwable {
        stock.tradeAt(aPrice);
    }

    @Then("^the alert status will be (.+)")
    public void the_alert_status_will_be_OFF(String aStatus) throws Throwable {
        assertThat(stock.getStatus(), is(valueOf(aStatus)));
    }

}
