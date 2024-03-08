Feature: Test Activity

  Scenario: Check Activity
    Given I hit the api
    When I Pass the URL
    Then verify Reponse Code is "200"
