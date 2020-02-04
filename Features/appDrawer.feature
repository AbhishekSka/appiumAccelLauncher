  Feature: Vertical view over the app drawer

    Scenario: Getting on to the vertical app drawer
      Given user is on homescreen
      When user presses menu
      Then user sees vertical app drawer
      And validates with "All Apps"

    Scenario: Search on app drawer
      Given user is on app drawer
      When  user tap on the search bar
      Then search view should be  activated
      And search bar is focused
      And keyboard could be seen


    Scenario: exiting form app drawer with swipe down
      Given User is on the app drawer
      When user performs swipe down
      Then user ends up on the homescreen

    Scenario : Exiting form app drawer with back button from navigation
      Given user is on app drawer
      When user hits back button
      Then user ends upon home screen

     Scenario: Opening hide app menu
       Given user is on the app drawer
       When user hit kebaab menu
       Then user sees drawer from below
       And drawer has "Hide apps"

     Scenario: Checking for the alphabet present according to installed application
       Given user is on app drawer
       When user checks for the alphabets
       Then use should only see those letter with at least one alphabet on it
