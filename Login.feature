Feature: Login
 @Register
  Scenario: Register new user in demo guru app
     Given User launches the url or application
   Given  user enters all details
    When user clicks on Submit button of reg
    Then USer logged into the application

  @Login
  Scenario: User is able to Login with Valid Credentials
   Given launch application
   And user enters <username> and <password>
   When User clicks on Submit button
   Then User logged in

   @InvalidCredential
   Scenario: Validate User is unable to Login with invalid credentials
    Given launch the application
    And user enters <inusername> and <inpassword>
    When User clicks on Submit button for invalid scenario
    Then User must not be able to login

    @BookFlight
    Scenario: Validate user is able to book flight
    Given launch application for booking flight
    And user enters her <username> and <password>
    When user clicks on flight book
    Then book flight last

