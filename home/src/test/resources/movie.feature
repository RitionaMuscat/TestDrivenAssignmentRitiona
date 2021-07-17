Feature: MainClass
Scenario: Missing User Input
  Given I dont pass the movie name
  Then I check that the warning message is provided
    
Scenario: Movie Name Written half capital and half small
	Given I write the movie name in a mixture of capital and small letters
	When I search for the movie
	Then Movie Details are returned

Scenario:  Authorized user is able to find a movie
	Given Movie is available
	When I search a movie
	Then Details are returned
	
Scenario: Jumbled Movie Name
	Given I input jumbled words
	When I search for the movie
	Then Return Movie Does Not Exist
	

Scenario: Multiple Movie Names
	Given I input multiple movie names 
	When I search for movie name
	Then I should not get the movie details
	
Scenario: Unauthorized users not able to see movie details
	Given I have an invalid API key
	Then 404 error should be returned
	
Scenario: Numeric and Symbol files
	Given I input characters and symbols
	Then No Movie Name is returned
	
Scenario: Invalid Characters (percentages)
	Given I enter a percentage with the movie name
	Then Movie Shall Not Be Returned 