Feature: Put User Profile Picture
  @Testing @PositiveCase @User @PutUserPicture
  Scenario Outline: Put profile with valid path and valid json body
    Given put user profile picture with valid req body
    When Send put user profile picture
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile picture JSON Schema
    Examples:
      | status  | message                            |
      | success | Berhasil Memperbarui Data Pengguna |

  @Testing @NegativeCase @User @PutUserPicture
  Scenario Outline: Put profile with empty req body picture
    Given put user profile picture with empty req body picture
    When Send put user profile picture
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile picture JSON Schema
    Examples:
      | status | message      |
      | failed | no such file |

  @Testing @NegativeCase @User @PutUserPicture
  Scenario Outline: Put profile with invalid req body picture
    Given put user profile picture with invalid req body picture
    When Send put user profile picture
    Then Status code should be 400 Bad Request
    And Response body status should be "<status>" and message contains "<message>"
    And Validate put user profile picture JSON Schema
    Examples:
      | status | message      |
      | failed | no such file |