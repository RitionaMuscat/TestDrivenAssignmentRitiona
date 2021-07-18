Feature: MainClass
Scenario: No currencies provided
  When I dont have any parameters passed
  |3|
  |''|
  Then I check that the warning is shown

Scenario:  Authorized user is able to convert amounts
	Given That The Conversion is available
	|50|
	|GBP|
	|EUR|
	|3|
	When I search with the parameters 
	|50|
	|GBP|
	|EUR|
	Then Conversion is Returned
	
Scenario: Small Case Currencies 
	Given I input small case currencies
	|50|
	|gbp|
	|eur|
	|3|
	When I search with these fields
	|50|
	|gbp|
	|eur|
	|3|
	Then Currency In Capital Letters
	

Scenario: Multiple Currencies in one field
	When I search for multiple currencies
	|0 50 32|
	|GBPEUR USD|
	|NZDRUR AUD|
	|3|
	Then No rates are returned
	
Scenario: Unauthorized Requests
	Given I have Invalid Keys
	Then 404 error is displayed
	
Scenario: Invalid Amount and Non Existant Currencies
	Given I input invalid amounts and non existant currencies
	|-1|
	|RTU|
	|OAQ|
	|3|
	Then Error Should Return
	
Scenario: Invalid Character
	Given I enter an invalid character
	|-1|
	|RTU-|
	|O+AQ|
	|3|
	Then Conversion is Invalid
	
Scenario: Extra Spaces In The Currency Field
	When I Input A space in Currency
	|5 0|
	| GB P|
	|EUR |
	|3|
	Then Currency Will Return as Invalid
	
Scenario: Pass a non numeric amount
	When I Input A non numeric amount
	|GBP|
	|GBP|
	|EUR|
	|three|
	|3|
	Then An exception will be thrown