Feature: Validating Place APIs

  Scenario: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload
    When User calls "AddPlaceAPI" with Post http request
    Then The API call is success with status code 200
    And "Status" in response body is "OK"
    And "Scope" in response body is "APP"

  Scenario: Verify if place is being successfully deleted using AddPlaceAPI
    Given Add Place Payload
    When User calls "DeletePlaceAPI" with Post http request
    Then The API call is success with status code 200
    And "Status" in response body is "OK"