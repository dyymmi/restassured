import org.junit.Test;

import java.util.Random;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetRestTest extends FunctionalTest {
    @Test
    public void basicPingTest() {
        given().when().get("/posts").then().statusCode(200);
    }

    @Test
    public void verifyPostName() {
        given().when().get("/posts/1").then()
                .body(containsString("sunt aut facere"));
    }

    @Test
    public void verifyExactTitle() {
        given().when().get("/posts/2").then()
                .body("title", equalTo("qui est esse"));
    }

    @Test
    public void verifyUsersCity() {
        given().when().get("/users/1").then()
                .body("address.city", equalTo("Gwenborough"));
    }

    @Test
    public void verifyUsingChaining() {
        given().when().get("users/2").then()
                .body("name", equalTo("Ervin Howell"))
                .body("address.zipcode", equalTo("90566-7771"))
                .body("address.geo.lat", equalTo("-43.9509"))
                .statusCode(200);
    }

    @Test
    public void getPostWithParam() throws Exception {
        Random random = new Random();
        int postId = random.nextInt(100) + 1;

        given().pathParam("postId", postId)
                .when().get("/posts/{postId}").then()
                .body("id", equalTo(postId));
    }

    @Test
    public void getPostsOfUser() {
        given().queryParam("userId", "9")
                .when().get("/posts")
                .then().body("findAll {it.userId}.id",
                hasItems(81, 82, 83, 84, 85, 86, 87, 88, 89, 90));
    }
}
