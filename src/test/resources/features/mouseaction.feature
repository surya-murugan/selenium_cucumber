
Feature: practice page

Background:
Given User is on the webpage

Scenario: User does Actions functions
When User hovers over the Pointme button
Then User clicks the mobiles button


Scenario: User uploads a file
When User clicks the file upload button
Then User uploads a file

#Table checkbox selection and javascript highlightings
Scenario: User selects "<device>" checkbox from the table
When User clicks the checkbox for "<device>"
#Then User verifies that the "<device>" checkbox is selected
  Examples:
    | device     |
    | smartwatch |
    | Television |
    | Soundbar   |



Scenario: Date picker selection
When User selects a "15 September 2026" date from the date picker
Then User verifies that the date displayed is correct

