Feature: Account page feature

Background:
Given user has already logged in to application
|username|password|
|anshulpurohit91@gmail.com|Selenium1234|


Scenario: Account page title
Given user is on account page
When user get the title of the page
Then page title should be "My Account"

Scenario: Account Section count
Given user is on account page
Then user get account section
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And Account section count should be 4