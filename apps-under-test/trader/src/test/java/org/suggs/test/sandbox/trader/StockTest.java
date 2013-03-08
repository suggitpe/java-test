package org.suggs.test.sandbox.trader;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StockTest {

    @Test
    public void shouldHaveAnInitialStateOfOff() {
        Stock stock = new Stock();
        assertThat(stock.getStatus(), is(Stock.STATUS.OFF));
    }

}
