package controllers;

import io.restassured.response.Response;
import specs.SpecStrategy;

import static io.restassured.RestAssured.given;

public class CommentsController extends BaseController {
    private static final String PATH = "/comments";

    public CommentsController(SpecStrategy specStrategy) {
        super(specStrategy);
    }

    public Response getComment(int id) {
        return given()
                .spec(spec)
                .basePath(PATH)
                .pathParam("id", id)
                .when()
                .get("/{id}");
    }
}
