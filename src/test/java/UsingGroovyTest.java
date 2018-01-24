import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class UsingGroovyTest extends FunctionalTest {
    @Test
    public void verifyPostId() {
        given().when().get("/posts/7/comments")
                .then().body("findAll {it.postId == 7}.id", hasItems(31, 32, 33, 34, 35));

    }
}
