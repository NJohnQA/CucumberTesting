Feature: Search on Google

Scenario: Searches for Kittens
	Given I can open Google
	When I search for kittens
	Then Google will give me Kittens