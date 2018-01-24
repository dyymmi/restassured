package controllers;

import io.restassured.response.Response;
import specs.SpecStrategy;

import static io.restassured.RestAssured.given;

public class PostsController extends BaseController {

    private static final String PATH = "/posts";

    public PostsController(SpecStrategy specStrategy) {
        super(specStrategy);
    }

    public Response getPost(int id) {
        return given()
                .spec(spec)
                .basePath(PATH)
                .pathParam("id", id)
                .when()
                .get("/{id}");
    }
}
