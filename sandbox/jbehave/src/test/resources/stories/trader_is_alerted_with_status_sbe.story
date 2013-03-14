Trader is alerted of status

Narrative:
Description I want to track the prices of stocks so that I can trade more effectively.  As such I need to be alerted when stock prices go above a threshold.
In order that I make a profit
As a person who likes to dabble in the stock market
I want to monitor stock market prices against thresholds

Scenario: Stock status is driven from price and threshold
Given a stock with a symbol of <symbol>
And a threshold of <threshold>
When the stock is traded at <price>
Then the alert status should be <status>

Examples:
|symbol|threshold|price|status|
|STK1  |20.0     |5.0  |OFF   |
|STK1  |20.0     |10.0 |OFF   |
|STK1  |20.0     |15.0 |OFF   |
|STK1  |20.0     |19.9 |OFF   |
|STK1  |20.0     |20.0 |ON    |
|STK1  |20.0     |25.0 |ON    |
