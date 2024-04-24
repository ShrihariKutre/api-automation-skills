Feature: Get Post Operations
  Test Get Post requests and verify response of API using RestAssured

#  Scenario: Verify one author of the post
#    Given I perform GET operation for "/post"
#    And I perform GET for the post number "1"
#    Then I should see the author name as "Karthik KK"

  @Get
  Scenario Outline: Verify Get
    Given I load test data
#    Given the API is up and running
#    When I send a GET request to the endpoint
#    Then the response status code should be 200
#    And the response body should contain "<expected_content>"
    Examples:
      | expected_content |
      | [  {  \"id\": \"5\",  \"title\": \"a title\",  \"views\": 100  },  {  \"id\": \"2\",  \"title\": \"another title\",\"views\": 200}] |


#  @Post
#  Scenario Outline: Verify Post
#    Given the API is up and running
#    When I send a POST request to "<endpoint>" create a user with id "<id>" and views <views>
#    Then the response status code should be 201
##    And the response body should contain "<expected_content>"
#    Examples:
#      | id | views | endpoint |
#      | 22 | 300 | /posts |

#  @Delete
#  Scenario Outline: Verify Post
#    Given the API is up and running
#    When I send a DELETE request to "<endpoint>" with views <views>
#    Then the response status code should be 200
##    And the response body should contain "<expected_content>"
#    Examples:
#      | views | endpoint |
#      | 400 | /posts/20 |