package code.with.vanilson.cucumber.glue;

/**
 * ProductControllerSteps
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductControllerSteps {

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private ResponseEntity<String> lastResponse;
    private final HttpHeaders headers = new HttpHeaders();
    private final String baseUrl = "http://localhost:8081";

    @Given("the product service is up and running")
    public void the_product_service_is_up_and_running() {
        // This step could be used to ensure the application context is loaded
    }

    @When("I request all products")
    public void i_request_all_products() {
        lastResponse = restTemplate.getForEntity(baseUrl + "/products", String.class);
    }

    @Then("I should receive a list of products")
    public void i_should_receive_a_list_of_products() {
        assertEquals(200, lastResponse.getStatusCode().value());
    }

    @Given("the product with ID {int} exists")
    public void the_product_with_ID_exists(int id) {
        // Create a product with ID 1 for testing purposes
        String url = baseUrl + "/products/create-product";
        String requestBody = "{\"id\": 1, \"name\": \"Test Product\", \"quantity\": 10, \"price\": 19.99}";
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        restTemplate.postForEntity(url, request, String.class);
    }

    @When("I request the product with ID {int}")
    public void i_request_the_product_with_ID(int id) {
        lastResponse = restTemplate.getForEntity(baseUrl + "/products/" + id, String.class);
    }

    @Then("I should receive the product details")
    public void i_should_receive_the_product_details() {
        assertEquals(200, lastResponse.getStatusCode().value());
    }

    @Given("I have a new product with name {string}, quantity {int} and price {double}")
    public void i_have_a_new_product_with_name_quantity_and_price(String name, int quantity, double price) {
        // Store the product details for the next step
        // Implemented in the When step below
    }

    @When("I create the product")
    public void i_create_the_product() {
        String url = baseUrl + "/products/create-product";
        String requestBody = "{\"name\": \"New Product\", \"quantity\": 10, \"price\": 99.99}";
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        lastResponse = restTemplate.postForEntity(url, request, String.class);
    }

    @Then("the product should be created")
    public void the_product_should_be_created() {
        assertEquals(201, lastResponse.getStatusCode().value());
    }

    @When("I update the product with ID {int} with new name {string}, quantity {int} and price {double}")
    public void i_update_the_product_with_ID_with_new_name_quantity_and_price(int id, String name, int quantity,
                                                                              double price) {
        String url = baseUrl + "/products/update-product/" + id;
        String requestBody = "{\"name\": \"" + name + "\", \"quantity\": " + quantity + ", \"price\": " + price + "}";
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        lastResponse = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
    }

    @Then("the product should be updated")
    public void the_product_should_be_updated() {
        assertEquals(200, lastResponse.getStatusCode().value());
    }

    @When("I delete the product with ID {int}")
    public void i_delete_the_product_with_ID(int id) {
        String url = baseUrl + "/products/delete-product/" + id;
        lastResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @Rollback(false)
    @Then("the product should be deleted")
    public void the_product_should_be_deleted() {
        assertEquals(204, lastResponse.getStatusCode().value());
    }

}