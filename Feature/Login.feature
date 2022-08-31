Feature: Biskane Login functionality

@forgetPassword
Scenario: Forget password link should dipalyed
Given  User should be on login page https://qa.biskane.com/login
Then Forget password link should displayed

@login
Scenario: Login with valid credentials
Given User should be on login page https://qa.biskane.com/login
When User enters valid username "pooja@katchintech.com"
And User enters valid password "Cust@123"
And User clicks on SignIn button
Then User shoud navigate to his DashBoard
And User logout from dashboard