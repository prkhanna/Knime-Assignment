Feature: Validating creation of new space


   Background: Login into knime application
   Given User accept the cookies
   And   User clicks on signin
   When  User login into knime

    Scenario: Verify creation and deletion of new space
        Given I click on user profile
        Then  I click on user account 
        When  I click on the 'public' space
        Then  Verify the 'success' message for new space
        When  I edit the existing space name 
        Then  Verify the 'rename' message for new space
        When   I delete the created space
        Then  Verify the 'deleted' message for new space
         