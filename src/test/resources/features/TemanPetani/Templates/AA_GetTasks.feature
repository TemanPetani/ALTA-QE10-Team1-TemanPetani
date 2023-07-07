Feature: Get Tasks Templates
  @Testing @PositiveCase @Templates @GetTaskTemplates
  Scenario Outline: Get All Task Templates with Valid ID
    Given get all task templates with valid ID
    When Send get task templates
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate success get all task templates JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Mendapatkan Data Template |

  @Testing @NegativeCase @Templates @GetTaskTemplates
  Scenario Outline: Get All Task Templates with Exceed ID
    Given get all task templates with exceed ID <id>
    When Send get task templates
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate failed get all task templates JSON Schema
    Examples:
      | id   | status | message                       |
      | 1000 | failed | Data Template Tidak Ditemukan |

  @Testing @NegativeCase @Templates @GetTaskTemplates
  Scenario Outline: Get All Task Templates with Invalid ID
    Given get all task templates with invalid ID "<id>"
    When Send get task templates
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate failed get all task templates JSON Schema
    Examples:
      | id  | status | message        |
      | aaa | failed | invalid syntax |