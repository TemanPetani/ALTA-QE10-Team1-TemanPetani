Feature: Put Schedule Templates
  @Testing @PositiveCase @Templates @PutScheduleTemplates
  Scenario Outline: Update schedule templates with valid req body and valid id
    Given put schedule templates with valid req body and ID
    When Send put schedule templates
    Then Status code should be 200 OK
    And Response body schedule status should be "<status>" and message contains "<message>"
    And Validate put schedule templates JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Memperbarui Data Template |

  @Testing @NegativeCase @Templates @PutScheduleTemplates
  Scenario Outline: Update schedule templates with valid req body and exceed id
    Given put schedule templates with valid req body and exceed ID <id>
    When Send put schedule templates
    Then Status code should be 404 Not Found
    And  Response body schedule status should be "<status>" and message contains "<message>"
    And Validate put schedule templates JSON Schema
    Examples:
      | id    | status | message                       |
      | 10000 | failed | Data Template Tidak Ditemukan |

  @Testing @NegativeCase @Templates @PutScheduleTemplates
  Scenario Outline: Update schedule templates with valid req body and invalid id
    Given put schedule templates with valid req body and invalid ID "<id>"
    When Send put schedule templates
    Then Status code should be 400 Bad Request
    And  Response body schedule status should be "<status>" and message contains "<message>"
    And Validate put schedule templates JSON Schema
    Examples:
      | id  | status | message        |
      | aaa | failed | invalid syntax |

  @Testing @NegativeCase @Templates @PutScheduleTemplates
  Scenario Outline: Update schedule templates with valid id and invalid req body name
    Given put schedule templates with valid ID and invalid req body name
    When Send put schedule templates
    Then Status code should be 400 Bad Request
    And  Response body schedule status should be "<status>" and message contains "<message>"
    And Validate put schedule templates JSON Schema
    Examples:
      | status | message         |
      | failed | expected=string |