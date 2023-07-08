Feature: Put Task Templates
  @Testing @PositiveCase @Templates @PutTaskTemplates
  Scenario Outline: Update tasks templates with valid req body and valid ID
    Given put task templates with valid req body and ID
    When Send put task templates
    Then Status code should be 200 OK
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
  Examples:
    | status  | message                            |
    | success | Berhasil Memperbarui Data Template |

  @Testing @NegativeCase @Templates @PutTaskTemplates
  Scenario Outline: Update tasks templates with valid req body and exceed ID
    Given put task templates with valid req body and exceed ID <id>
    When Send put task templates
    Then Status code should be 404 Not Found
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
    Examples:
      | id   | status | message                       |
      | 1000 | failed | Data Template Tidak Ditemukan |


  @Testing @PositiveCase @Templates @PutTaskTemplates
  Scenario Outline: Update tasks templates with valid req body and invalid ID
    Given put task templates with valid req body and invalid ID "<id>"
    When Send put task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
    Examples:
      | id  | status | message        |
      | aaa | failed | invalid syntax |

  @Testing @PositiveCase @Templates @PutTaskTemplates
  Scenario Outline: Update tasks templates with valid ID and invalid req body name
    Given put task templates with valid ID <id> and invalid req body name
    When Send put task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
    Examples:
      | id | status | message         |
      | 1  | failed | expected=string |

  @Testing @PositiveCase @Templates @PutTaskTemplates
  Scenario Outline: Update tasks templates with valid ID and invalid req body start day
    Given put task templates with valid ID <id> and invalid req body start days
    When Send put task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
    Examples:
      | id | status | message       |
      | 1  | failed | expected=uint |

  @Testing @PositiveCase @Templates @PutTaskTemplates
  Scenario Outline: Update task templates with valid ID and register req body name
    Given put task templates with valid ID and register req body name
    When Send put task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate put task templates JSON Schema
    Examples:
      | status | message         |
      | failed | Duplicate entry |