Feature: As a user all the installed app could be made visible or invisible

  Background: user is already on the app drawer

  Scenario: User is on the Hide apps menu
    Given user taps Kebaab button
    When user taps hide menu
    Then user could see "Hide apps" label


  Scenario: User hides app form the hide menu
    Given user is on the hide app menu
    When user taps on camera app
    And hits "Close"/back
    And user is in the app drawer page
    Then user shouldn't see the camera app

  Scenario: To hide multiple applications
    Given user is on the hide app menu
    When user taps on camera app,chrome,
    And Swipe left
    And user taps on Google,Phone
    And hits "Close"/back
    And user is in the app drawer page
    Then user shouldn't see the all the apps

  Scenario: Search for the applications on the hide app search bar
    Given user is on the hide app menu
    When user enters <keyword>
    Then user see  <result>

  Example:
  |keyword|result|
  |"Ca"|"Calculator,Camera,Calendar"|
  |"Play"|"Play Store,Play Games, Play Music, Play Movies"|

  Scenario: Clearing of search bar after the search
    Given user is on hide app menu
    And user enters <keyword>
    When user hits backspace to remove keyword
    Then app should be sorted as per horizontal alphabetical order

  Example:
  |keyword|result|
  |"Ca"|"Calculator,Camera,Calendar"|
  |"Play"|"Play Store,Play Games, Play Music, Play Movies"|



