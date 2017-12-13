import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class PostRestTest extends FunctionalTest {
    @Test
    public void addPost() {
        Map<String, String> post = new HashMap<String, String>();
        post.put("title", "Test RestAssured post");
        post.put("body", "RestAssured post body test content");
        post.put("userId", "7");

        given()
                .contentType("application/json")
                .body(post)
                .when().post("/posts")
                .then().statusCode(201);
    }
}
