Feature: Post New User
  @Testing @PositiveCase @User @PostUser
  Scenario Outline: Create new user with valid req body
    Given post new user with valid req body
    When Send post create new user
    Then Status code should be 201 Created
    And Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Pengguna Baru |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with registered email
    Given post new user with registered email
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message         |
      | failed | Duplicate entry |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with registered phone
    Given post new user with registered phone
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message         |
      | failed | Duplicate entry |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with empty fullname
    Given post new user with empty fullname
    When Send post create new user
    Then Status code should be 400 Bad Request
    And Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                                  |
      | failed | Field validation for 'FullName' failed on the 'required' |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with empty email
    Given post new user with empty email
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                               |
      | failed | Field validation for 'Email' failed on the 'required' |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with empty password
    Given post new user with empty password
    When Send post create new user
    Then Status code should be 400 Bad Request
    And Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                                  |
      | failed | Field validation for 'Password' failed on the 'required' |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with empty phone
    Given post new user with empty phone
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                               |
      | failed | Field validation for 'Phone' failed on the 'required' |

  @Testing @PositiveCase @User @PostUser
  Scenario Outline: Create new user with empty address
    Given post new user with empty address
    When Send post create new user
    Then Status code should be 201 Created
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Pengguna Baru |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with password less than 8
    Given post new user with password less than 8
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                       |
      | failed | Password harus memiliki setidaknya 8 karakter |

  @Testing @PositiveCase @User @PostUser
  Scenario Outline: Create new user with password length is 8
    Given post new user with password length is 8
    When Send post create new user
    Then Status code should be 201 Created
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Pengguna Baru |

  @Testing @PositiveCase @User @PostUser
  Scenario Outline: Create new user with password more than 8
    Given post new user with password more than 8
    When Send post create new user
    Then Status code should be 201 Created
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status  | message                        |
      | success | Berhasil Membuat Pengguna Baru |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with password without uppercase
    Given post new user with password without uppercase
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                         |
      | failed | Field validation for 'Password' include uppercase |

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with password without special character
    Given post new user with password without special char
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                              |
      | failed | Field validation for 'Password' include special char|

  @Testing @NegativeCase @User @PostUser
  Scenario Outline: Create new user with password without number
    Given post new user with password without number
    When Send post create new user
    Then Status code should be 400 Bad Request
    And  Response body post create new user status should be "<status>" and message contains "<message>"
    And Validate post create new user JSON Schema
    Examples:
      | status | message                                        |
      | failed | Field validation for 'Password' include number |