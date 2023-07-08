Feature: Delete Task Template
  @Testing @PositiveCase @Templates @DeleteTaskTemplates
  Scenario Outline: Delete task templates with valid ID
    Given delete task templates with valid ID
    When Send delete task templates
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate delete task templates JSON Schema
    Examples:
      | status  | message                          |
      | success | Berhasil Menghapus Data Template |

  @Testing @NegativeCase @Templates @DeleteTaskTemplates
  Scenario Outline: Delete task templates with exceed ID
    Given delete task templates with exceed ID <id>
    When Send delete task templates
    Then Status code should be 404 Not Found
    And Response body status should be "<status>" and message contains "<message>"
    And Validate delete task templates JSON Schema
    Examples:
      | id    | status | message                       |
      | 10000 | failed | Data Template Tidak Ditemukan |

  @Testing @NegativeCase @Templates @DeleteTaskTemplates
  Scenario Outline: Delete task templates with invalid ID
    Given delete task templates with invalid ID "<id>"
    When Send delete task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate delete task templates JSON Schema
    Examples:
      | id  | status | message          |
      | aa! | failed | invalid syntax   |