import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class PostRestTest extends FunctionalTest {

    @Test
    public void AddPost() {
        Map<String, String> post = new HashMap<String, String>(); //Hashmap is not suitable for mixed value types.
        post.put("title", "Test RestAssured post");
        post.put("body", "RestAssured post body test content");
        post.put("userId", "7"); //Here should be int but it's not possible

        given()
                .contentType("application/json")
                .body(post)
                .when().post("/posts")
                .then().statusCode(201);
    }
}
