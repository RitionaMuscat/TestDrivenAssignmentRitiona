Feature: MainClass
Scenario: No word is provided 
  When I dont pass the word
  Then I check that the warning message is provided
    
Scenario:  Authorized user is able to find a definition
	Given Definition is available
	|rascals|
	When I search a movie
	|rascals|
	Then Details are returned
	
Scenario: Jumbled Definition
	Given I input jumbled words
	|ajfisdfj|
	|grogjfi|
	|dffjsiod|
	When I search for the word
	|ajfisdfj|
	|grogjfi|
	|dffjsiod|
	Then Return Word Does Not Exist
	

Scenario: Multiple Movie Names
	When I search for movie name
	|lucifer friends simpson|
	|[Good Doctor] Bob anthony|
	Then I should not get the movie details
	
Scenario: Unauthorized users not able to see movie details
	Given I have an invalid API key
	Then 404 error should be returned
	
Scenario: Numeric and Symbol files
	Given I input characters and symbols
	|friends123|
	Then No Movie Name is returned
	
Scenario: Invalid Characters (percentages)
	Given I enter a percentage with the movie name
	|%fri%ends%|
	Then Movie Shall Not Be Returned 