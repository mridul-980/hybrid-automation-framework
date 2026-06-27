package api.utils;

import static io.restassured.RestAssured.given;

import api.specs.BaseSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    public static Response get(String endpoint) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .when()
                .get(endpoint);
    }

    public static Response getWithPathParam(
            String endpoint,
            String pathParam,
            Object value) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .pathParam(pathParam, value)
                .when()
                .get(endpoint);
    }
    
    public static Response getWithQueryParam(
            String endpoint,
            String queryParam,
            Object value) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .queryParam(queryParam, value)
                .when()
                .get(endpoint);
    }
    public static Response getWithAuth(
            RequestSpecification requestSpec,
            String endpoint,
            String pathParam,
            Object value) {

        return given()
                .spec(requestSpec)
                .pathParam(pathParam, value)
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint,
                                Object payload) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .body(payload)
                .when()
                .post(endpoint);
    }

    public static Response put(String endpoint,
                               String pathParam,
                               Object value,
                               Object payload) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .pathParam(pathParam, value)
                .body(payload)
                .when()
                .put(endpoint);
    }

    public static Response patch(String endpoint,
                                 String pathParam,
                                 Object value,
                                 Object payload) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .pathParam(pathParam, value)
                .body(payload)
                .when()
                .patch(endpoint);
    }

    public static Response delete(String endpoint,
                                  String pathParam,
                                  Object value) {

        return given()
                .spec(BaseSpec.getRequestSpec())
                .pathParam(pathParam, value)
                .when()
                .delete(endpoint);
    }
}