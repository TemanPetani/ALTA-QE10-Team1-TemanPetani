Feature: Delete Schedule Template
  @Testing @PositiveCase @Templates @DeleteScheduleTemplates
  Scenario Outline: Delete schedule templates with valid ID
    Given delete schedule templates with valid ID
    When Send delete schedule templates
    Then Status code should be 200 OK
    And Response body schedule status should be "<status>" and message contains "<message>"
    And Validate delete schedule templates JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Mendapatkan Data Template |

  @Testing @NegativeCase @Templates @DeleteScheduleTemplates
  Scenario Outline: Delete schedule templates with exceed ID
    Given delete schedule templates with exceed ID <id>
    When Send delete schedule templates
    Then Status code should be 200 OK
    And Response body schedule status should be "<status>" and message contains "<message>"
    And Validate delete schedule templates JSON Schema
    Examples:
      | id    | status | message          |
      | 10000 | failed | error parse data |

  @Testing @NegativeCase @Templates @DeleteScheduleTemplates
  Scenario Outline: Delete schedule templates with invalid ID
    Given delete schedule templates with invalid ID "<id>"
    When Send delete schedule templates
    Then Status code should be 200 OK
    And Response body schedule status should be "<status>" and message contains "<message>"
    And Validate delete schedule templates JSON Schema
    Examples:
      | id  | status | message          |
      | aa! | failed | error parse data |