#Trello Test Automation

##Overview
This project is a complete end-to-end (E2E) test suite for automating interactions with the Trello website. The suite is built using the TestNG framework with the Page Object Model (POM) and Maven for dependency management. The tests cover various scenarios, including user login, board creation, list management, card management, and cleanup operations.

##Project Structure
The project follows the Page Object Model (POM) design pattern to ensure a clean and maintainable codebase. The structure includes:

Page Object Classes: Separate classes for each page on the Trello website, encapsulating page elements and actions.
Test Classes: Contains the test methods that perform the actual test scenarios.
Utility Classes: Helper methods and reusable functions.
Configuration Files: Stores configuration properties and private data.
##Scenarios Covered
Logging In:

Automates the login process using valid credentials.
Board Creation:

Creates a new board named "VaultN".
List Management:

Adds multiple lists to the created board.
Card Management:

Adds cards to specific lists and moves them between different statuses.
Cleanup:

Closes and deletes the board after completing the test.
Prerequisites
Java Development Kit (JDK): Version 8 or higher.
Maven: For managing project dependencies and building the project.
TestNG: For running the test suite.
