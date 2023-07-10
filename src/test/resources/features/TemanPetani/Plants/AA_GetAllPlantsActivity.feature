Feature: Get List Plants
  @Testing @PositiveCase @Plants @GetAllPlantsActivity
  Scenario Outline: Get All Plant Activities with valid auth
    Given get all plant activity with valid auth
    When Send get plant activity
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate success get all plant activity JSON Schema
    Examples:
      | status  | message                           |
      | success | Berhasil Mendapatkan Data Tanaman |

  @Testing @NegativeCase @Plants @GetAllPlantsActivity
  Scenario Outline: Get All Plant Activities without auth
    Given get all plant activity without auth
    When Send get plant activity
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get all plant activity JSON Schema
    Examples:
      | message                  |
      | missing or malformed jwt |

  @Testing @NegativeCase @Plants @GetAllPlantsActivity
  Scenario Outline: Get All Plant Activities with invalid auth
    Given get all plant activity with invalid auth
    When Send get plant activity
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get all plant activity JSON Schema
    Examples:
      | message                |
      | invalid or expired jwt |