Feature: Student Email Verification
  @studentEmail
  Scenario: Each Student email Validation
    When user hits students API
    Then user verify email contains properly characters