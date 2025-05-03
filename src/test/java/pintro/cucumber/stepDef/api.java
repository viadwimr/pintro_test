package pintro.cucumber.stepDef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;


public class api {
    Response response;

    @When("I send GET request to {string}")
    public void send_get(String endpoint) {
        response = given().when().get("https://jsonplaceholder.typicode.com" + endpoint);
    }

    @When("I send POST request to {string} with title and body")
    public void send_post(String endpoint) {
        JSONObject req = new JSONObject();
        req.put("title", "Test");
        req.put("body", "Ini isi post");
        req.put("userId", 1);

        response = given()
                .header("Content-Type", "application/json")
                .body(req.toString())
                .when()
                .post("https://jsonplaceholder.typicode.com" + endpoint);
    }

    @When("I send PATCH request to {string} with updated title")
    public void send_patch(String endpoint) {
        JSONObject update = new JSONObject();
        update.put("title", "Updated Title");

        response = given()
                .header("Content-Type", "application/json")
                .body(update.toString())
                .when()
                .patch("https://jsonplaceholder.typicode.com" + endpoint);
    }

    @Then("I receive status code {int}")
    public void check_status(int code) {
        assertEquals(code, response.statusCode());
    }

    @Then("Response contains post ID {int}")
    public void check_post_id(int id) {
        assertEquals(id, response.jsonPath().getInt("id"));
    }

    @Then("Response contains a list of posts")
    public void check_list_response() {
        List<?> posts = response.jsonPath().getList("$");
        assertTrue(posts.size() > 0);
    }

    @Then("Only the title is updated")
    public void check_patch_result() {
        assertEquals("Updated Title", response.jsonPath().getString("title"));
    }

    @Then("Response time should be less than 500ms")
    public void check_response_time() {
        assertTrue(response.timeIn(TimeUnit.MILLISECONDS) < 500);
    }
}

