Feature: Customer

  Background: steps that common to all scenarios
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view the Dashboard

  @regression
  Scenario: Add New customer
    When User click on Customers menu
    And Click on Customers Items
    Then User click on Add new hyperlink
    Then User enter customers info
    And click on Save button
    Then User should view the confirmation message "The new customer has been added successfully."
    And close browser

    @sanity @regression
    Scenario: Search Customer by Email
      When User click on Customers menu
      And Click on Customers Items
      And Enter Customer Email
      When Click on search button
      Then user should found Email in the search table
      And close browser

      @sanity @regression
  Scenario: Search Customer by Name
    When User click on Customers menu
    And Click on Customers Items
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click on search button
    Then user should found Name in the search table
    And close browser

