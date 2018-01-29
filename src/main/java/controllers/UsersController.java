package controllers;

import io.restassured.response.Response;
import specs.SpecStrategy;

import static io.restassured.RestAssured.given;

public class UsersController extends BaseController {

    private static final String PATH = "/users";

    public UsersController(SpecStrategy specStrategy) {
        super(specStrategy);
    }

    public Response getUser(int id) {
        return given()
                .spec(spec)
                .basePath(PATH)
                .pathParam("id", id)
                .when()
                .get("/{id}");
    }
}
