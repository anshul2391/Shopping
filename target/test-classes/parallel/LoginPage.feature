Feature: Login Page Failure

Scenario: Login page title
Given user is on login page
When user get the title of the page
Then page title should be "Account Login"

Scenario: Forgot password link
Given user is on login page
Then Forgot your password link should be displayed

Scenario: Login with correct credentials 
Given user is on login page
When user enters username "anshulpurohit91@gmail.com"
And user enters password "Selenium1234"
And user clicks on login button
Then user get the title of the page
And page title should be "My Account"