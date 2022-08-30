Feature: Verify shop page of Biskane

Background:
Given User has already logged into the application
|username|password|
|pooja@katchintech.com|Cust@123|

@verifyShopPage
Scenario: Count Categories on shop page
Given User is on DashBoard page
When User clicks on Home link on Header
And User clicks on Shop Now link
Then User should Navigate to https://qa.biskane.com/shop-Indigenous page
When User count number of Categories on shop page
And User click on Dashboard
And User logout from dashboard
