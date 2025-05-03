Feature: Register ellrow
Scenario: user able to checkout the product
  Given user is on products page
  And user click add cart button on one of product
  And user click cart simbol button
  And user click checkout button
  And user send personal data
  When user click the finish button
  Then user will see the success message