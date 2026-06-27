package api.endpoints;

import java.util.Map;

import api.auth.AuthSpec;
import api.models.UserPayload;
import api.utils.ApiClient;
import api.utils.ApiConstants;
import io.restassured.response.Response;

// This class defines the API endpoints related to user operations.
// Request now uses centralized specification from BaseSpec, which promotes reusability and maintainability.

public class UserEndpoints {

	public static Response getUser(int userId) { // Method to get a user by ID using GET request

		return ApiClient.getWithPathParam( // Using centralized ApiClient to handle GET request
				ApiConstants.USER_BY_ID, "id", userId);
	}

	/*
	 * return given() .spec(BaseSpec.getRequestSpec()) .pathParam("id", userId)
	 * .when() .get(ApiConstants.USER_BY_ID); // .get("/users/{id}"); // Using path
	 * parameter for user ID
	 */

	public static Response createUser( // Method to create a new user using POST request
			UserPayload payload) {

		return ApiClient.post( // Using centralized ApiClient to handle POST request
				ApiConstants.USERS, payload);
	}

	public static Response getUserWithAuth( // Method to get a user with authentication using GET request
			int userId) {

		return ApiClient.getWithAuth( // Using centralized ApiClient to handle GET request with authentication
				AuthSpec.getAuthSpec(), ApiConstants.USER_BY_ID, "id", userId);
	}

	public static Response updateUser( // Method to update a user using PUT request
			int userId, UserPayload payload) {

		return ApiClient.put( // Using centralized ApiClient to handle PUT request
				ApiConstants.USER_BY_ID, "id", userId, payload);
	}

	public static Response deleteUser( // Method to delete a user using DELETE request
			int userId) {

		return ApiClient.delete( // Using centralized ApiClient to handle DELETE request
				ApiConstants.USER_BY_ID, "id", userId);
	}

	public static Response patchUser( // Method to partially update a user using PATCH request
			int userId, Map<String, Object> payload) {

		return ApiClient.patch( // Using centralized ApiClient to handle PATCH request
				ApiConstants.USER_BY_ID, "id", userId, payload);
	}

	public static Response getUsersByPage( // Method to get users by page using GET request, it is useful for pagination
											// and retrieving a list of users
			int page) {

		return ApiClient.getWithQueryParam( // Using centralized ApiClient to handle GET request with query parameter for
								// pagination
				ApiConstants.USERS, "page", page);
	}
}