@users

  Feature: Get user for specified id
    Scenario: Send request and verify users schema
      When I get user for id 1
      Then returned JSON is compliant with "user-schema"