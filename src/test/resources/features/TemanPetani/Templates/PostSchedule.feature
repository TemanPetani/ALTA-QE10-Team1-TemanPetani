Feature: Post Schedule Templates
  @Testing @PositiveCase @Templates @PostScheduleTemplates
  Scenario Outline: Add Schedule Templates with Valid Req Body
    Given post schedule templates with valid req body
    When Send post create schedule templates
    Then Status code should be 201 Created
    And  Response body post create new user should be "<status>" and message contains "<message>"
    And Validate post create schedule templates JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Template Baru |

  @Testing @NegativeCase @Templates @PostScheduleTemplates
  Scenario Outline: Add Schedule Templates with Empty Req Body Name
    Given post schedule templates with empty req body name
    When Send post create schedule templates
    Then Status code should be 400 Bad Request
    And  Response body post create new user should be "<status>" and message contains "<message>"
    And Validate post create schedule templates JSON Schema
    Examples:
      | status | message                                              |
      | failed | Field validation for 'Name' failed on the 'required' |

  @Testing @NegativeCase @Templates @PostScheduleTemplates
  Scenario Outline: Add Schedule Templates with Invalid Req Body Name
    Given post schedule templates with invalid req body name
    When Send post create schedule templates
    Then Status code should be 400 Bad Request
    And  Response body post create new user should be "<status>" and message contains "<message>"
    And Validate post create schedule templates JSON Schema
    Examples:
      | status | message         |
      | failed | expected=string |