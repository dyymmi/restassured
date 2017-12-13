import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidation extends FunctionalTest {
    @Test
    public void userSchemaValidation() {
        given().when().get("/users/1")
                .then().assertThat().body(matchesJsonSchemaInClasspath("user-schema.json"));
    }
}
