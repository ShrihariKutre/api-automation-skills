Feature: Verification of HTTP requests and responses
#  Background: Test data is loaded


  @Get
  Scenario Outline: Verify Get API
    Given The API is up and running to hit the "Get" request for test data <data_id>
    When User sends the request to the endpoint
    Then User can verify the response status code
    Then User can verify the response body
    Examples:
      | data_id |
      |    1    |
      |    2    |
      |    3    |

  @Post
  Scenario Outline: Verify Post API
    Given The API is up and running to hit the "Post" request for test data <data_id>
    When User sends the request to the endpoint
    Then User can verify the response status code
    Then User can verify the response body
    Examples:
      | data_id |
      |    1    |
      |    2    |
      |    3    |

  @Put
  Scenario Outline: Verify Put API
    Given The API is up and running to hit the "Put" request for test data <data_id>
    When User sends the request to the endpoint
    Then User can verify the response status code
    Then User can verify the response body
    Examples:
      | data_id |
      |    1    |
      |    2    |
      |    3    |

  @Delete
  Scenario Outline: Verify Delete API
    Given The API is up and running to hit the "Delete" request for test data <data_id>
    When User sends the request to the endpoint
    Then User can verify the response status code
    Then User can verify the response body
    Examples:
      | data_id |
      |    1    |
      |    2    |
      |    3    |