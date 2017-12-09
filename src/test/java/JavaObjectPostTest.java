import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class JavaObjectPostTest extends FunctionalTest {

    private String title;
    private String body;
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Test
    public void SendJavaObject() throws Exception {
        JavaObjectPostTest javaObjectPostTest = new JavaObjectPostTest();
        javaObjectPostTest.setTitle("Java object post title");
        javaObjectPostTest.setBody("Java object post body");
        javaObjectPostTest.setUserId("7");

        given().contentType("application/json").body(javaObjectPostTest)
                .when().post("/posts")
                .then().statusCode(201);
    }
}
