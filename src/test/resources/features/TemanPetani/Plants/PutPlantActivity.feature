Feature: Put Plant Activity
  @Testing @PositiveCase @Plants @PutPlantsActivity
  Scenario Outline: Update Plant Activity with valid req body and valid id
    Given Put plant activity with valid req body and valid ID
    When Send put plant activity
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate plant activity JSON Schema
    Examples:
      | status  | message                           |
      | success | Berhasil Memperbarui Data Tanaman |

  @Testing @NegativeCase @Plants @PutPlantsActivity
  Scenario Outline: Update Plant Activity with valid req body and exceed id
    Given Put plant activity with valid req body and exceed ID <id>
    When Send put plant activity
    Then Status code should be 404 Not Found
    And Response body status should be "<status>" and message contains "<message>"
    And Validate plant activity JSON Schema
    Examples:
      | id   | status | message          |
      | 1000 | failed | record not found |

  @Testing @NegativeCase @Plants @PutPlantsActivity
  Scenario Outline: Update Plant Activity with valid req body and invalid id
    Given Put plant activity with valid req body and invalid ID "<id>"
    When Send put plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate plant activity JSON Schema
    Examples:
      | id  | status | message        |
      | aaa | failed | invalid syntax |

  @Testing @NegativeCase @Plants @PutPlantsActivity
  Scenario Outline: Update Plant Activity with valid id and invalid req body completed date
    Given Put plant activity with valid ID and invalid req body completed date
    When Send put plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate plant activity JSON Schema
    Examples:
      | status | message                    |
      | failed | input is not a JSON string |

  @Testing @NegativeCase @Plants @PutPlantsActivity
  Scenario Outline: Update Plant Activity with valid id and invalid format req body completed date
    Given Put plant activity with valid ID and invalid format req body completed date
    When Send put plant activity
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate plant activity JSON Schema
    Examples:
      | status | message              |
      | failed | message=parsing time |
