@Regression1
Feature: End to End Test for account creation

  Background: Setup test and generate token
    #Step 1) Create Valid token
    * def result = callonce read('GenerateToken.feature')
    * def validToken = result.response.token
    #Step 2) Create New Account
    * def createAccountResult = callonce read('CreateAccount1.feature')
    * def createdAccountId = createAccountResult.response.id
    * def dataGenerator = Java.type('api.utility.data.GenerateData')
    * def phoneNumber = dataGenerator.RandomPhoneNumber()
    * def licencePlate = dataGenerator.generateLicensePlate()
    * def addressLine1 = dataGenerator.addressGenerator("stAddress")
    * def cityValue = dataGenerator.addressGenerator("cityValue")
    * def zipCodeValue = dataGenerator.addressGenerator("zipCodeValue")
    * def stateValue = dataGenerator.addressGenerator("stateValue")
    Given url "https://tek-insurance-api.azurewebsites.net"

  Scenario: End to End Test for account creation
    #Step 3) Add Phone to created account
    Given path "/api/accounts/add-account-phone"
    And param primaryPersonId = createdAccountId
    And header Authorization = "Bearer " + validToken
    And request
      """
      {
        "phoneNumber": "#(phoneNumber)",
        "phoneExtension": "",
        "phoneTime": "Evening",
        "phoneType": "Mobile"
      }
      """
    When method post
    Then status 201
    And print response
    #Step 4) Add Address to created account
    And path "/api/accounts/add-account-address"
    And param primaryPersonId = createdAccountId
    And header Authorization = "Bearer " + validToken
    And request
      """
      {
        "addressType": "Home",
        "addressLine1": "#(addressLine1)",
        "city": "#(cityValue)",
        "state": "#(stateValue)",
        "postalCode": "#(zipCodeValue)",
        "countryCode": "United States",
        "current": true
      }
      """
    When method post
    Then status 201
    And print response
    #Add Car to created account
    And path "/api/accounts/add-account-car"
    And param primaryPersonId = createdAccountId
    And header Authorization = "Bearer " + validToken
    And request
      """
      {
        "make": "Toyota",
        "model": "Venza",
        "year": "2013",
        "licensePlate": "#(licencePlate)"
      }
      """
    When method post
    Then status 201
    And print response
    #Delete created account
    Given path "/api/accounts/delete-account"
    And param primaryPersonId = createdAccountId
    And header Authorization = "Bearer " + validToken
    When method delete
    Then status 200
    And print response
    And assert response == "Account Successfully deleted"
