Feature: Search bar on the home screen for the Accel launcher
  As a user, search bar should be made available on the home screen and should be activated with tap or swipe up

  Description: User launches the Accel launcher
  And each bar could be accessed form home screen

  Scenario: Launch of Accel launcher
    Given User is on the home screen
    When User launches the Accel launcher
    Then User sees Search bar
    And Search bar consist of placeholder "Seach apps,contacts"

  Scenario: Focus on the search bar for very first time
    When User taps on the search bar field
    Then User sees onscreen keyboard
    And User should not see the search history


  Scenario: Focus on the search bar after previous few searches
    Given User is on Home screen
    When User taps on the search bar field
    Then User sees onscreen keyboard
    And User can see the search history

    #positive testing

  Scenario Outline: Search with character,word, to view web recommendation,app,contacts and settings
    Given User is in home screen
    And user focuses on the search bar
    When Search with <characters>
    Then user should see the web recommendation,app,contacts and settings related to <character>
    Examples:
      | characters | Web    | app      | contacts | settings                                   |
      | 'd'        | Daraz  | Calendar | Downey   | 'Device info' 'Display' 'Sound and Volume' |
      | 'x'        | xiaomi | Firefox  | -        | -                                          |
      | '{'        | -      | -        | -        | -                                          |

  Scenario: Search with word to view web recommendation,app,contacts and settings
    Given User is in home screen
    And user focuses on the search bar
    When Search with <word>
    Then user should see the web recommendation,app,contacts and settings related to <word>

  Example:
  | word | Web | app |contacts |settings |
  | 'Cont' | content  | Contact | -   | -  |
  | 'x' | xiaomi  | Firefox | -  |  -  |
  | '</script>'| -  | - | -  |  -  |

  Scenario Outline: Web search through search bar home screen
    Given User is in home screen
    And user taps search bar
    When user enters <text>
    Then User gets redirect to search engine of the default browser through proxy
    And User sees required <results>
    Examples:
      | text      | results                                  |
      | '/'       | Redirected to search engine default page |
      | "'"       | search results for approstophe           |
      | 'spotify' | seraches on the spofity                  |

  Scenario: Search with character/word to view web recommendation,app,contacts and settings and hits back button
    Given User is in home screen
    And user searches with text on the search bar
    When User hits  back button
    Then user gets back to seach view with search historhy and recomendations

  Scenario: Web search through search bar home screen 100+ characters
    Given User is in home screen
    And user taps search bar
    When user enters 100+ characters
    Then User gets redirect to search engine of the default browser through proxy
    And User sees required results
   
   #Negative testing
  Scenario: Web search through search bar home screen
    Given User is in home screen
    And user taps search bar
    When user taps 'Done' from keyboard
    Then User should stay on search screen






Feature Description

Feature: Search content

Feature Description

Feature: Search history

Feature: