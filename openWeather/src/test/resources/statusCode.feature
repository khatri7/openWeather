Feature: Verify GET request on openweathermap API

Scenario: Verify status code after request is made
	Given The baseURI is set as "http://api.openweathermap.org/data/2.5/find"
	And the parameters q is "bengaluru" and units is "metrics" and appid is "2470d8a942478fc83d733ba5f98716c2"
	When a GET request is made
	Then verify that status code is 200
	
Scenario Outline: Verify status code after request is made for different cities
	Given The baseURI is set as "http://api.openweathermap.org/data/2.5/find"
	And the parameters q is "<city>" and units is "metrics" and appid is "2470d8a942478fc83d733ba5f98716c2"
	When a GET request is made
	Then verify that status code is 200
	And print the name of the city
	
	Examples:
	|	city	|
	|	bengaluru	|
	|	jaipur	|
	|	delhi |