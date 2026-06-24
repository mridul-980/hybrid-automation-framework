package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.Map;

import api.models.UserPayload;
import api.specs.BaseSpec;
import io.restassured.response.Response;

// This class defines the API endpoints related to user operations.
// Request now uses centralized specification from BaseSpec, which promotes reusability and maintainability.

public class UserEndpoints {

    public static Response getUser(int userId) {    // Method to get a user by ID using GET request

    	 return given()
    	            .spec(BaseSpec.getRequestSpec())
    	            .pathParam("id", userId)
    	            .when()
    	            .get("/users/{id}");      // Using path parameter for user ID
    }
    
    public static Response createUser(      // Method to create a new user using POST request
            UserPayload payload) {

        return

                given()

                .spec(BaseSpec.getRequestSpec())

                .body(payload)  // Payload is now passed as an object, and RestAssured will handle serialization.

                .when()

                .post("/users");
    }
    
    public static Response getUserWithAuth(     // Method to get a user with authentication using GET request
    	     int userId) {

        return given()
                .spec(
                    api.auth.AuthSpec
                        .getAuthSpec())
                .pathParam("id", userId)
                .when()
                .get("/users/{id}");         // Using path parameter for user ID
    }
    
    public static Response updateUser(          // Method to update a user using PUT request
    	     int userId,
    	        UserPayload payload) {

    	    return given()
    	            .spec(BaseSpec.getRequestSpec())
    	            .pathParam("id", userId)
    	            .body(payload)
    	            .when()
    	            .put("/users/{id}");
    }
    public static Response deleteUser(        // Method to delete a user using DELETE request
    	     int userId) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .pathParam("id", userId)
                .when()
                .delete("/users/{id}");
    }
    public static Response patchUser(        // Method to partially update a user using PATCH request
    	     int userId,
    	        Map<String, Object> payload) {

    	    return given()
    	            .spec(BaseSpec.getRequestSpec())
    	            .pathParam("id", userId)
    	            .body(payload)
    	            .when()
    	            .patch("/users/{id}");
    }
    
    public static Response getUsersByPage(        // Method to get users by page using GET request, it is useful for pagination and retrieving a list of users
            int page) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .queryParam("page", page)
                .when()
                .get("/users");
    }
}