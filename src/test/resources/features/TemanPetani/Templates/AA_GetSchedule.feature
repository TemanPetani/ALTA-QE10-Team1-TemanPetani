Feature: Get All Schedule Templates
  @Testing @PositiveCase @Templates @GetScheduleTemplates
  Scenario Outline: Get List Schedule Templates with valid auth
    Given get list schedule templates with valid auth
    When Send get schedule templates
    Then Status code should be 200 OK
    And Response body get user status should be "<status>", message contains "<message>", and data schedule is exist
    And Validate success get list schedule JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Mendapatkan Data Template |

  @Testing @NegativeCase @Templates @GetScheduleTemplates
  Scenario Outline: Get list schedule templates without auth
    Given get list schedule templates without auth
    When Send get schedule templates
    Then Status code should be 401 Unauthorized
    And Response body get schedule message contains "<message>"
    And Validate failed get list schedule JSON Schema
    Examples:
      | message                  |
      | missing or malformed jwt |

  @Testing @NegativeCase @Templates @GetScheduleTemplates
  Scenario Outline: Get list schedule templates invalid auth
    Given get list schedule templates invalid auth
    When Send get schedule templates
    Then Status code should be 401 Unauthorized
    And Response body get schedule message contains "<message>"
    And Validate failed get list schedule JSON Schema
    Examples:
      | message                |
      | invalid or expired jwt |