Feature: Post Plant Activity
  @Testing @PositiveCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activity with Valid Req Body
    Given Post plant activity with valid req body
    When Send post plant activity
    Then Status code should be 201 Created
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status  | message                  |
      | success | Berhasil Membuat Tanaman |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with empty req body templateId
    Given Post plant activity with empty req body templateId
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                                                    |
      | failed | Field validation for 'TemplateID' failed on the 'required' |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with empty req body name
    Given Post plant activity with empty req body name
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                                              |
      | failed | Field validation for 'Name' failed on the 'required' |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with empty req body start date
    Given Post plant activity with empty req body start date
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                                                   |
      | failed | Field validation for 'StartDate' failed on the 'required' |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with invalid req body templateId
    Given Post plant activity with invalid req body template id
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                 |
      | failed | cannot unmarshal string |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with invalid req body name
    Given Post plant activity with invalid req body name
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                 |
      | failed | cannot unmarshal number |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with invalid req body start date
    Given Post plant activity with invalid format req body start date
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message              |
      | failed | message=parsing time |

  @Testing @NegativeCase @Plants @PostPlantActivity
  Scenario Outline: Add Plant Activities with exceed req body templateId
    Given post plant activity with exceed req body templateId
    When Send post plant activity
    Then Status code should be 400 Bad Request
    And  Response body status should be "<status>" and message contains "<message>"
    And Validate post plant activity JSON Schema
    Examples:
      | status | message                        |
      | failed | a foreign key constraint fails |