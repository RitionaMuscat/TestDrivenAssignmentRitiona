Feature: MainClass
Scenario: Missing User Input
  Given I dont pass the movie name
  Then I check that the warning message is provided
    
Scenario: Movie Name Written half capital and half small
	When I search for 
	|fRiEnDs|
	Then "Movie: Friends Rating: Good (8.9) Plot: Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan." should be returned

Scenario:  Authorized user is able to find a movie
	Given Movie is available
	|little rascals|
	When I search a movie
	|little rascals|
	Then Details are returned
	
Scenario: Jumbled Movie Name
	Given I input jumbled words
	|ajfisdfj|
	|grogjfiodg|
	|dffjsiod|
	When I search for the movie
	|ajfisdfj|
	|grogjfiodg|
	|dffjsiod|
	Then Return Movie Does Not Exist
	

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