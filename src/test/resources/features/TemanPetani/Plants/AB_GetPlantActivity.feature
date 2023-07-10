Feature: Get Plant By ID
  @Testing @PositiveCase @Plants @GetDetailPlantsActivity
  Scenario Outline: Get Plant Activity with Valid ID
    Given get plant activity with valid ID
    When Send get detail plant activity
    Then Status code should be 200 OK
    And Response body plant id as id path, status should be "<status>", and message contains "<message>"
    And Validate success get plant activity JSON Schema
    Examples:
      | status  | message                           |
      | success | Berhasil Mendapatkan Data Tanaman |

  @Testing @NegativeCase @Plants @GetDetailPlantsActivity
  Scenario Outline: Get Plant Activity with Exceed ID
    Given get plant activity with exceed ID <id>
    When Send get detail plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate failed get plant activity JSON Schema
    Examples:
      | id   | status | message          |
      | 1000 | failed | record not found |

  @Testing @PositiveCase @Plants @GetDetailPlantsActivity
  Scenario Outline: Get Plant Activity with Invalid ID
    Given get plant activity with invalid ID "<id>"
    When Send get detail plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate failed get plant activity JSON Schema
    Examples:
      | id | status | message        |
      | aa | failed | invalid syntax |