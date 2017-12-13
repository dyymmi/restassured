import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class JavaObjectPostTest extends FunctionalTest {

    private String title;
    private String body;
    private int userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Test
    public void sendJavaObject() throws Exception {
        JavaObjectPostTest javaObjectPostTest = new JavaObjectPostTest();
        javaObjectPostTest.setTitle("Test RestAssured post");
        javaObjectPostTest.setBody("RestAssured post body test content");
        javaObjectPostTest.setUserId(7);

        given().contentType("application/json").body(javaObjectPostTest)
                .when().post("/posts")
                .then().statusCode(201);
    }

    @Test
    public void AddPostAndVerify() throws Exception {
        JavaObjectPostTest javaObjectPostTest = new JavaObjectPostTest();
        javaObjectPostTest.setTitle("Test RestAssured post");
        javaObjectPostTest.setBody("RestAssured post body test content");
        javaObjectPostTest.setUserId(7);

        Response response = given().contentType("application/json")
                .body(javaObjectPostTest)
                .when().post("/posts")
                .then().extract().response();

        Assert.assertEquals(101, response.path("id"));
        Assert.assertEquals("Test RestAssured post", response.path("title"));
        Assert.assertEquals("RestAssured post body test content", response.path("body"));
        Assert.assertEquals(7, response.path("userId"));


    }
}
