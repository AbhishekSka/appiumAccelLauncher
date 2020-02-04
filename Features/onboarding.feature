Feature: On first installation of the app, user onboarding view should be enabled to guide user through app
  Background: User has installed the app

  Scenario: Checking for the onboarding screen
    Given user launches the app for very first time
    Then user see "Welcome to Accel Launcher"
    And user see "Begin" button

  Scenario:  Follow the onboarding flow to enter the app
    Given user is on the welcome onboarding screen
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
