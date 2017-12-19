import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class HeadersTest extends FunctionalTest {
    @Test
    public void getAllHeaders() {
        Response response = get("posts/1");

        Headers headers = response.getHeaders();
        //System.out.println(headers);
    }

    @Test
    public void verifyContentType() {
        Response response = given().when().get("posts/1");
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals("application/json; charset=utf-8", contentType);
    }

    @Test
    public void getAllCookies() {
        Response response = given().when().get("posts/1");
        Map<String, String> allCookies = response.getCookies();
        System.out.println(allCookies);
    }
}
