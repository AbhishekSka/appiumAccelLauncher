Feature: On first installation of the app, user onboarding view should be enabled to guide user through app

  Background: User has installed the app

  Scenario: Checking for the onboarding screen
    Given user launches the app for very first time
    Then user see "Welcome to Accel Launcher"
    And user see "Begin" button

  Scenario:  Follow the onboarding flow to enter the app
    Given user is on the "welcome onboarding" screen
    When user taps "BEGIN"
    Then user ends up on "Accel Launcher" screen
    And user see "NEXT" Button
    And user see "SKIP" Button

  Scenario:  Follow the onboarding flow to enter the app
    Given user is on "Accel Launcher" screen
    When user taps "NEXT"
    Then user ends up on "Hide apps" screen
    And user see "NEXT" Button
    And user see "SKIP" Button


  Scenario:  Follow the onboarding flow to enter the app
    Given user is on "Hide apps" screen
    When user taps "NEXT"
    Then user ends up on "Gestures" screen
    And user see "NEXT" Button
    And user see "SKIP" Button

  Scenario:  Follow the onboarding flow to enter the app
    Given user is on "Gestures" screen
    When user taps "NEXT"
    Then user ends up on "Accelrate your productivity" screen
    And user see "NEXT" Button

  Scenario:  Follow the onboarding flow to enter the app
    Given user is on "Accelrate your productivity" screen
    When user taps "NEXT"
    Then user ends up on confirmation dialog for permission
    And accepting would allow user to enter Home screen


  Scenario Outline:User skips the onboarding
    Given user is on <onboarding> screen
    When user taps "SKIP"
    Then user ends up on "Accelrate your productivity" screen
    And user see "NEXT" Button

    Examples:
      | onboarding       |
      | "Accel Launcher" |
      | "Hide apps"      |
      | "Gestures"       |

  Feature: As a  user, i should be allowed to use accel launcher as its default launcher

  Scenario: User sees Accel Launcher as default launcher
    Given user is on "Accelrate your productivity" screen"
    When user taps "NEXT"
    And user allow all required permissions
    Then user end up on home screen
    But user should see "Set As default" button

  Scenario: User sets Accel launcher as default launcher
    Rule: User launches launcher for very first time and complete onboarding

    Given User is on the home screen
      And user sees "Set as default"
      When user taps "Set as default" button
      Then Launcher sets as default launcher