Feature: MainClass
Scenario: No word is provided 
  When I dont pass the word
  Then I check that the warning message is shown

Scenario:  Authorized user is able to find a definition
	Given Definition is available
	|rascals|
	When I search a movie
	|rascals|
	Then Details are returned
	
Scenario: Jumbled Definition
	Given I input jumbled multiple items
	|ajfisdfj|
	|grogjfi|
	|dffjsiod|
	When I search for the item
	|ajfisdfj|
	|grogjfi|
	|dffjsiod|
	Then Return Word is invalid
	

Scenario: Multiple Words
	When I search for multiple words
	|fries chicken eggs|
	|[Rhinousours] Burgers|
	Then I should not get the movie details
	
Scenario: Unauthorized 
	Given I have an invalid key
	Then 404 error is returned
	
Scenario: Numeric Word
	Given I input numbers in the word
	|apple123|
	Then No Definition to be returned
	
Scenario: Invalid Characters (percentages)
	Given I enter a percentage with the definition name
	|%fr%es%|
	Then Definition Shall Not Be Returned
	
Scenario: Extra Spaces In The Word
	When I Input A Word with spaces
	| Apple |
	Then Word Should be provided