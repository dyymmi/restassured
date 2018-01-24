@posts
Feature: Get post for specified identifier

  Scenario: Send request and verify post content
    When I get post for id 1
    Then Returned post should have id 1
    And title should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    And userId should be 1