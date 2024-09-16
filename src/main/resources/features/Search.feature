@Run
Feature: Search
  Background:
    Given The user is on the homepage

  Scenario: User Search query is Accepted
    When they type a "Deadpool" into the search bar
    Then the search query should be accepted and processed

  Scenario: Only Relative Items Returned in the results
    Given The user has entered a search query
    When they click the Search button or press Enter key
    Then the search results page should display items matching the search query

  Scenario: Verify that the No Results Found message is displayed when there are no matching items
      Given The user enters a search query
      When no items match the search query
      Then a "No Results Found" message should be displayed

  Scenario: Verify that user can search with partially movie name
      Given the user enters movie name partially in the search field
      When they click the Search button or press Enter key
      Then products relevant to that name should be displayed

  Scenario: Verify that correct movie is proceed when clicking to a movie
    When they searches for "Deadpool" into the search bar
    And click on it's image
    Then the "Deadpool" movie should be displayed
