Feature: About Testers
  
  In order to get a high paid job
  As a Tester
  I want to learn Automation

  Scenario Outline: I am a Manual Tester
    Given I am a "<testerType>" Tester
      | Location | Position  |
      | USA      | Contract  |
      | India    | Permanent |
    When I apply for a job
    Then I got a "<jobType>" paid job
    And I am "<satisfactionType>" satisfied with my salary
    But My parents are "<parentSatisfaction>" satisfied

    Examples: 
      | testerType | jobType | satisfactionType | parentSatisfaction |
      | Manual     | Less    | Low              | Average            |
      | Automation | High    | Very             | Highly             |
      | Database   | Good    | Better           | Better             |
