Feature: A trader is alerted to status changes
  In order that I make a profit
  As a person who likes to dabble in the stock market
  I want to monitor stock market prices against thresholds

  Scenario Outline:
    Given a stock of <symbol>
    And a threshold of <threshold>
    When the stock is traded with <price>
    Then the alert status will be <status>

  Examples:
    | symbol | threshold | price | status |
    | STK1   | 20.0      | 5.0   | OFF    |
    | STK1   | 20.0      | 10.0  | OFF    |
    | STK1   | 20.0      | 15.0  | OFF    |
    | STK1   | 20.0      | 19.9  | OFF    |
    | STK1   | 20.0      | 20.0  | ON     |
    | STK1   | 20.0      | 25.0  | ON     |