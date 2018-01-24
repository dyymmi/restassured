import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends FunctionalTest {
    @Test
    public void userSchemaValidation() {
        given().when().get("/users/1")
                .then().assertThat().body(matchesJsonSchemaInClasspath("user-schema.json"));
    }
}
