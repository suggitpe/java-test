Feature: I want to have a game where I can create a grid and toggle the grid points as I go along
  In order to fulfil my day
  As a person who likes to play games
  I want to play a game of life with myself

  Scenario: With a square grid I can change various points on the grid
    Given a 5 by 5 game
    When I toggle the cell at (2, 3)
    Then the grid should look like
    """
    .....
    .....
    .....
    ..X..
    .....
    """
    When I toggle the cell at (2, 4)
    Then the grid should look like
    """
    .....
    .....
    .....
    ..X..
    ..X..
    """
    When I toggle the cell at (2, 3)
    Then the grid should look like
    """"
    .....
    .....
    .....
    .....
    ..X..
    """

  Scenario: With a rectangular  grid I can change various points on the grid
    Given a 6 by 2 game
    When I toggle the cell at (0, 0)
    Then the grid should look like
    """
    X.....
    ......
    """
    When I toggle the cell at (1, 1)
    Then the grid should look like
    """
    X.....
    .X....
    """
    When I toggle the cell at (0, 0)
    Then the grid should look like
    """
    ......
    .X....
    """
    When I toggle the cell at (1, 1)
    Then the grid should look like
    """
    ......
    ......
    """
    When I toggle the cell at (4, 0)
    Then the grid should look like
    """
    ....X.
    ......
    """
    When I toggle the cell at (2, 1)
    Then the grid should look like
    """
    ....X.
    ..X...
    """