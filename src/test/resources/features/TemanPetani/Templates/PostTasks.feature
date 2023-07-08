Feature: Post Task Templates
  @Testing @PositiveCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid Req Body and ID
    Given post task templates with valid req body and ID
    When Send post task templates
    Then Status code should be 201 Created
    And Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Template Baru |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid Req Body and Exceed ID
    Given post task templates with valid req body and exceed ID <id>
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id    | status | message                                                          |
      | 10000 | failed | Cannot add or update a child row: a foreign key constraint fails |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid Req Body and Invalid ID
    Given post task templates with valid req body and invalid ID "<id>"
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id | status | message        |
      | a@ | failed | invalid syntax |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid ID and Empty Req Body Name
    Given post task templates with valid ID <id> and empty req body name
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id | status | message                                              |
      | 1  | failed | Field validation for 'Name' failed on the 'required' |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid ID and Empty Req Body Start Day
    Given post task templates with valid ID <id> and empty req body start day
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id | status | message                                                   |
      | 1  | failed | Field validation for 'StartDays' failed on the 'required' |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid ID and Invalid Req Body Name
    Given post task templates with valid ID <id> and invalid req body name
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id | status | message         |
      | 1  | failed | expected=string |

  @Testing @NegativeCase @Templates @PostTasksTemplates
  Scenario Outline: Add Tasks Templates with Valid ID and Invalid Req Body Start Day
    Given post task templates with valid ID <id> and invalid req body start day
    When Send post task templates
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post create task templates JSON Schema
    Examples:
      | id | status | message       |
      | 1  | failed | expected=uint |