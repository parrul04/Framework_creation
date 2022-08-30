Feature: Biskane Login functionality

@login
Scenario: Login with valid credentials
Given User should be on login page https://qa.biskane.com/login
When User enters valid username "pooja@katchintech.com"
And User enters valid password "Cust@123"
And User clicks on SignIn button
Then User shoud navigate to his DashBoard
And User logout from dashboard