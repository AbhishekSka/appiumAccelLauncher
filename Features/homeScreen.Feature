Feature: As a user user should be able to see favourite icons including App drawer menu on primary home screen

  Scenario: Phone,Messaging,App Drawer,Camera and Chrome as favourite apps
    Given User is on the home screen
    Then user should see Phone,Messaging,App Drawer,Camera and Chrome apps on bottom

  Scenario: App drawer button should be immovable
    Given User is in Home Screen
    When user performs long press drag on App drawer button
    Then App drawer button should be fixed and non dragable


  Scenario: User should only be only be allowed to add 5 apps as favourite
    Given Bottom panel of home screen consists of 5 apps
    When user drags and releases any app to Home screen bottom panel
    Then Message "No more roome in Favourite tray" should be displayed

  Scenario: Addition of app over any other apps on the bottom should create folder
    Given Bottom panel of home screen consists of an app
    When User drags and release any app to home screen bottom panel over the app
    Then Folder should be created with both app should be created

  Scenario: Addition of app over App drawer button
    Given User is in Home screen
    When User drags and release any app to home screen bottom panel over the App drawer button
    Then Message "No more roome in Favourite tray" should be displayed


Feature: Two screen on the initial installation

  Scenario: Presence of two initial screen on home screen with indicators on primary
    Given user is int the home screen
    Then user should see two dot
    And Dot indicator of screen in which user should be highlighted

  Scenario: Moving from primary screen to another
    Given User is in Home screen
    When user preforms swipe right
    Then user should get redirected to another screen
    And Dot indicator of that scree should be highlighted

