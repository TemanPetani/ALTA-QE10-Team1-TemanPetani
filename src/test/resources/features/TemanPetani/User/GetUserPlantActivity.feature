Feature: Get User Plant Activity
  @Testing @PositiveCase @User @UserPlantActivity
  Scenario Outline: Get user plant activities with valid auth
    Given get user plant activities with valid auth
    When Send get user plant activities
    Then Status code should be 200 OK
    And Response body get user status should be "<status>", message contains "<message>", and data is exist
    And Validate get user plant activities JSON Schema
    Examples:
      | status  | message                           |
      | success | Berhasil Mendapatkan Data Tanaman |

  @Testing @NegativeCase @User @UserPlantActivity
  Scenario Outline: Get user plant activities with empty auth
    Given get user plant activities with empty auth
    When Send get user plant activities
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate get user plant activities JSON Schema
    Examples:
      | message                  |
      | missing or malformed jwt |

  @Testing @NegativeCase @User @UserPlantActivity
  Scenario Outline: Get user plant activities with invalid auth
    Given get user plant activities with invalid auth
    When Send get user plant activities
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate get user plant activities JSON Schema
    Examples:
      | message                |
      | invalid or expired jwt |