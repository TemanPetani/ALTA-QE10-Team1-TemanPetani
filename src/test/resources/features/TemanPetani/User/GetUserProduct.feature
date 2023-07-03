Feature: Get User Product
  @Testing @PositiveCase @User @UserProduct
  Scenario Outline: Get user products with valid auth
    Given get user products with valid auth
    When Send get user products
    Then Status code should be 200 OK
    And Response body get user status should be "<status>", message contains "<message>", and data product is exist
    And Validate success get user product JSON Schema
    Examples:
      | status  | message                           |
      | success | Berhasil mendapatkan sejumlah produk |

  @Testing @NegativeCase @User @UserProduct
  Scenario Outline: Get user products with empty auth
    Given get user products with empty auth
    When Send get user products
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get user product JSON Schema
    Examples:
      | message                  |
      | missing or malformed jwt |

  @Testing @NegativeCase @User @UserProduct
  Scenario Outline: Get user product with invalid auth
    Given get user product with invalid auth
    When Send get user products
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get user product JSON Schema
    Examples:
      | message                |
      | invalid or expired jwt |