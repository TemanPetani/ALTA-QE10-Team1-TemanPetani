Feature: Put User
  @Testing @PositiveCase @User @PutUser
  Scenario Outline: Put profile with valid path and valid json body
    Given put user profile with valid path and valid json body
    When Send put user profile
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Memperbarui Data Pengguna |

  @Testing @NegativeCase @User @PutUser
  Scenario Outline: Put profile with invalid email req body
    Given put user profile with invalid email req body
    When Send put user profile
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile JSON Schema
    Examples:
      | status | message         |
      | failed | expected=string |

  @Testing @NegativeCase @User @PutUser
  Scenario Outline: Put profile with invalid password req body
    Given put user profile with invalid password req body
    When Send put user profile
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile JSON Schema
    Examples:
      | status | message         |
      | failed | expected=string |

  @Testing @NegativeCase @User @PutUser
  Scenario Outline: Put profile with invalid fullname req body
    Given put user profile with invalid fullname req body
    When Send put user profile
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile JSON Schema
    Examples:
      | status | message         |
      | failed | expected=string |