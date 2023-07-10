Feature: Get Plant Notifications
  @Testing @PositiveCase @Plants @GetPlantsNotification
  Scenario Outline: Get All Plant Activities Notification with valid auth
    Given Get plant activity notif notif with valid auth
    When Send get plant activity notif
    Then Status code should be 200 OK
    And Response body status should be "<status>" and message contains "<message>"
    And Validate success get plant activity notif JSON Schema
    Examples:
      | status  | message                              |
      | success | Berhasil Mendapatkan Data Notifikasi |

  @Testing @NegativeCase @Plants @GetPlantsNotification
  Scenario Outline: Get All Plant Activities Notification without auth
    Given Get plant activity notif without auth
    When Send get plant activity notif
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get plant activity notif JSON Schema
    Examples:
      | message                  |
      | missing or malformed jwt |

  @Testing @NegativeCase @Plants @GetPlantsNotification
  Scenario Outline: Get All Plant Activities Notification with invalid auth
    Given Get plant activity notif with invalid auth
    When Send get plant activity notif
    Then Status code should be 401 Unauthorized
    And Response body message contains "<message>"
    And Validate failed get plant activity notif JSON Schema
    Examples:
      | message                |
      | invalid or expired jwt |