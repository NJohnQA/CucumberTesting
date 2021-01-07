Feature: Add user to website

Scenario: Creates account
	Given I can open Demo site
	When I create an account
	Then I can log in to demo site