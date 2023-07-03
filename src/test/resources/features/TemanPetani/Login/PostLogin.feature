Feature: Post Login User
  @Testing @PositiveCase @Login
  Scenario Outline: Post login user with valid email and password for Role Admin
    Given post login with valid email and password for role admin
    When Send post login user
    Then Status code should be 200 OK
    And Response body post login status should be "<status>", message should be "<message>", and token is exist
    And Validate post login JSON Schema
    Examples:
      | status  | message        |
      | success | Berhasil Login |

  @Testing @PositiveCase @Login
  Scenario Outline: Post login user with valid email and password for Role User
    Given post login with valid email and password for role user
    When Send post login user for role user
    Then Status code should be 200 OK
    And Response body post login status should be "<status>", message should be "<message>", and token is exist
    And Validate post login JSON Schema
    Examples:
      | status  | message        |
      | success | Berhasil Login |

  @Testing @NegativeCase @Login
  Scenario Outline: Post login user with valid email and empty password
    Given post login with valid email and empty password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body post login status should be "<status>" and message should be "<message>"
    And Validate failed post login JSON Schema
    Examples:
      | status | message                        |
      | failed | Email dan Password Harus Diisi |

  @Testing @NegativeCase @Login
  Scenario Outline: Post login user with empty email and valid password
    Given post login with valid empty email and valid password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body post login status should be "<status>" and message should be "<message>"
    And Validate failed post login JSON Schema
    Examples:
      | status | message                        |
      | failed | Email dan Password Harus Diisi |

  @Testing @NegativeCase @Login
  Scenario Outline: Post login user with empty email and password
    Given post login with valid empty email and password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body post login status should be "<status>" and message should be "<message>"
    And Validate failed post login JSON Schema
    Examples:
      | status | message                        |
      | failed | Email dan Password Harus Diisi |

  @Testing @NegativeCase @Login
  Scenario Outline: Post login user with unregistered email and wrong password
    Given post login with unregistered email and wrong password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body post login status should be "<status>" and message should be "<message>"
    And Validate failed post login JSON Schema
    Examples:
      | status | message        |
      | failed | Password Salah |

  @Testing @NegativeCase @Login
  Scenario Outline: Post login user with valid email and wrong password
    Given post login with valid email and wrong password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body post login status should be "<status>" and message should be "<message>"
    And Validate failed post login JSON Schema
    Examples:
      | status | message        |
      | failed | Password Salah |