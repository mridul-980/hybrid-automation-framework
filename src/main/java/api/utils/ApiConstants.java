package api.utils;

public final class ApiConstants {

    private ApiConstants() {
        // Prevent instantiation
    }


    // Base Endpoints
    public static final String USERS = "/users";
    public static final String USER_BY_ID = "/users/{id}";

    // Test Data
    public static final String USERS_JSON = "users.json";

    // Schema Files
    public static final String USER_SCHEMA = "user-schema.json";
    public static final String CREATE_USER_SCHEMA = "create-user-schema.json";
    public static final String UPDATE_USER_SCHEMA = "update-user-schema.json";
    public static final String PATCH_USER_SCHEMA = "patch-user-schema.json";
}