@addbook
Feature: Books functionality

@addbook@db
  Scenario: As a librarian, I should be able to add new books to the library
    Given the user logged in as "librarian"
    When I navigate to "Books" page
    And the librarian click to add book
    And the librarian enter book name "<Book Name>"
    And The librarian fill out the table
    And click the button save changes
    And the book has been created notification should appear
    Then the librarian should see this book in database
