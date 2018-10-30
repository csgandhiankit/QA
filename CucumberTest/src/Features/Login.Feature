#Author: Ankit Gandhi
#Company: Infosys
#TestPage: http://zero.webappsecurity.com/
#Date: 10/10/18


@Smoke @P1
Feature: Login Functionality Test
  As a user when I enter valid id and password 
  I should be able to logIn into the ZeroBank App successfully.
  #Role / Goal / Value
  #As a user when I enter valid credential I should be able to logIn into application successfully

  Scenario: User should be able to logIn into the ZeroBank app with valid logIn
    Given I should be able to launch the ZeroBank app
    And I should be on 'Home Page'
    And I click on 'SgnIn' button
    And I land on 'LogIn' page
    When I enter logIn id as 'username'
    And I enter password as 'password'
    And I click on 'SignIn' button
    Then I should be able to logIn into the ZeroBank app I should land on 'User Dash Board'
