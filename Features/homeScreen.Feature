Feature: As a user user should be able to see favourite icons including App drawer menu on primary home screen

  Scenario: Phone,Messaging,App Drawer,Camera and Chrome as favourite apps
    Given User is on the home screen
    Then user should see Phone,Messaging,App Drawer,Camera and Chrome apps on bottom

  Scenario: App drawer button should be immovable
    Given User is in Home Screen
    When user performs long press drag on App drawer button
    Then user should be fixed


