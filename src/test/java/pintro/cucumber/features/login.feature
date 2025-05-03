Feature: Login dengan valid input
  Scenario: User login berhasil
    Given User masuk ke halaman login Swaglabs
    And User memasukkan "username"
    And User memasukkan "password"
    When User mengklik tombol "login"
    Then User berhasil dapat melihat halaman "products"