Feature: Get Users
  @Testing @PositiveCase @User @GetUser
  Scenario Outline: Get user profile with valid auth
    Given Get user profile with valid auth
    When Send get user profile
    Then Status code should be 200 OK
    And Response body get user status should be "<status>", message contains "<message>", and data is exist
    And Validate success get user profile JSON Schema
    Examples:
      | status  | message        |
      | success | Berhasil Mendapatkan Data Pengguna |

  @Testing @NegativeCase @User @GetUser
  Scenario Outline: Get user profile with invalid auth
    Given Get user profile with invalid auth
    When Send get user profile
    Then Status code should be 401 Unauthorized
    And Response body get user message contains "<message>"
    And Validate failed get user profile JSON Schema message
    Examples:
      | message                |
      | invalid or expired jwt |

  @Testing @NegativeCase @User @GetUser
  Scenario Outline: Get user profile with invalid path
    Given Get user profile with invalid path
    When Send get user profile invalid path
    Then Status code should be 404 Not Found
    And Response body get user message contains "<message>"
    And Validate failed get user profile JSON Schema message
    Examples:
      | message   |
      | Not Found |