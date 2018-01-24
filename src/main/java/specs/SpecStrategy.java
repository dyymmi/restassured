package specs;

import io.restassured.specification.RequestSpecification;

public interface SpecStrategy {

    RequestSpecification buildRequestSpecification();
}