@comments
Feature: Get comment for specified identifier

  Scenario Outline: Send request and verify comment content
    When I get comment for id <commentId>
    Then Returned comment should have id <commentId>
    And name should be "<name>"
    And email should be "<email>"
    Examples:
      | commentId | name                                                            | email              |
      | 1         | id labore ex et quam laborum                                    | Eliseo@gardner.biz |
      | 7         | repellat consequatur praesentium vel minus molestias voluptatum | Dallas@ole.me      |