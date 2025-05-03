Feature: Posts API Test Suite

  Scenario: Get single post by ID
    When I send GET request to "/posts/1"
    Then I receive status code 200
    And Response contains post ID 1

  Scenario: Create new post
    When I send POST request to "/posts" with title and body
    Then I receive status code 201
    And Response contains new post data

  Scenario: Update post partially
    When I send PATCH request to "/posts/1" with updated title
    Then I receive status code 200
    And Only the title is updated

  Scenario: List all posts
    When I send GET request to "/posts"
    Then I receive status code 200
    And Response contains a list of posts

  Scenario: Get non-existent post
    When I send GET request to "/posts/9999"
    Then I receive status code 404

  Scenario: Check response time for list post
    When I send GET request to "/posts"
    Then Response time should be less than 500ms
