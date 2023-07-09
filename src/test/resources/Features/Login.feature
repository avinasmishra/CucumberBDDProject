Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credential
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login123"
    And close browser

    Scenario Outline: Successful Login with Valid Credential DDT
      Given User launch chrome browser
      When User opens URL "https://admin-demo.nopcommerce.com/login"
      And User enters Email as "<Email>" and Password as "<Password>"
      And Click on Login
      Then Page Title should be "Dashboard / nopCommerce administration"
      When User click on Logout link
      Then Page Title should be "Your store. Login"
      And close browser

      Examples:
      |Email|Password|
      |admin@yourstore.com|admin|
      |test@yourstore.com|admin|

