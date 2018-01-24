
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicAuthTest {
    @BeforeClass
    public static void setUp() throws Exception {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 80;
        } else RestAssured.port = Integer.valueOf(port);

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://httpbin.org/";
        }
        RestAssured.baseURI = baseHost;
    }

    @Test
    public void basicAuthSuccess() {
        given().auth().preemptive().basic("user", "passwd")
                .when().get("/basic-auth/user/passwd")
                .then().body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }

    @Test
    public void preemptiveBasicAuthSuccess() {
        given().auth().basic("user", "passwd")
                .when().get("/basic-auth/user/passwd")
                .then().body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }

    @Test
    public void basicAuthFail() {
        given().auth().preemptive().basic("user", "passwd")
                .when().get("/basic-auth/user/password")
                .then().statusCode(401);
    }

    @Test
    public void preemptiveBasicAuthFail() {
        given().auth().basic("user", "passwd")
                .when().get("/basic-auth/user/passwordd")
                .then().statusCode(401);
    }
}
