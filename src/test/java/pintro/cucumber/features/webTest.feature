Feature: Login ke SauceDemo

  # ✅ Skenario Positif
  @web
  Scenario: Login dengan user valid ✅
    Given User membuka halaman login
    When User mengisi "username" dengan "standard_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat halaman dashboard

  @web
  Scenario: Login dengan user problem_user ✅
    Given User membuka halaman login
    When User mengisi "username" dengan "problem_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat halaman dashboard

  @web
  Scenario: Login dengan user performance_glitch_user ✅
    Given User membuka halaman login
    When User mengisi "username" dengan "performance_glitch_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat halaman dashboard

  @web
  Scenario: Login dengan user visual_user ✅
    Given User membuka halaman login
    When User mengisi "username" dengan "visual_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat halaman dashboard

  @web
  Scenario: Login, lalu logout kembali ✅
    Given User membuka halaman login
    When User mengisi "username" dengan "standard_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    And User klik tombol logout
    Then User kembali ke halaman login

  # ❌ Skenario Negatif
  @web
  Scenario: Login dengan username salah, password benar ❌
    Given User membuka halaman login
    When User mengisi "username" dengan "invalid_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Login dengan username benar, password salah ❌
    Given User membuka halaman login
    When User mengisi "username" dengan "standard_user"
    And User mengisi "password" dengan "wrong_password"
    And User klik tombol login
    Then User melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Login dengan username kosong ❌
    Given User membuka halaman login
    When User mengisi "username" dengan ""
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat pesan error "Epic sadface: Username is required"

  @web
  Scenario: Login dengan password kosong ❌
    Given User membuka halaman login
    When User mengisi "username" dengan "standard_user"
    And User mengisi "password" dengan ""
    And User klik tombol login
    Then User melihat pesan error "Epic sadface: Password is required"

  @web
  Scenario: Login dengan akun locked_out_user ❌
    Given User membuka halaman login
    When User mengisi "username" dengan "locked_out_user"
    And User mengisi "password" dengan "secret_sauce"
    And User klik tombol login
    Then User melihat pesan error "Epic sadface: Sorry, this user has been locked out."
