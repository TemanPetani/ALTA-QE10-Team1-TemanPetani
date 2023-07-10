Feature: Delete Plant Activity
  @Testing @PositiveCase @Plants @DeletePlantsActivity
  Scenario Outline: Delete Plant Activities with valid ID
    Given Delete plant activity with valid ID
    When Send delete plant activity
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate delete plant activity JSON Schema
    Examples:
      | status  | message                         |
      | success | Berhasil Menghapus Data Tanaman |

  @Testing @NegativeCase @Plants @DeletePlantsActivity
  Scenario Outline: Delete Plant Activities with exceed ID
    Given Delete plant activity with valid req body and exceed ID <id>
    When Send delete plant activity
    Then Status code should be 404 Not Found
    And Response body status should be "<status>" and message contains "<message>"
    And Validate delete plant activity JSON Schema
    Examples:
      | id   | status | message          |
      | 1000 | failed | record not found |

  @Testing @NegativeCase @Plants @DeletePlantsActivity
  Scenario Outline: Delete Plant Activities with invalid ID
    Given Delete plant activity with valid req body and invalid ID "<id>"
    When Send delete plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate delete plant activity JSON Schema
    Examples:
      | id  | status | message        |
      | aaa | failed | invalid syntax |