package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.TestConfiguration;

public class DefaultSpecStrategy implements SpecStrategy {

    public RequestSpecification buildRequestSpecification() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(TestConfiguration.getBaseUrl())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}