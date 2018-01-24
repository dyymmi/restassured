package controllers;

import io.restassured.specification.RequestSpecification;
import specs.SpecStrategy;

public abstract class BaseController {

    protected RequestSpecification spec;

    public BaseController(SpecStrategy specStrategy) {
        this.spec = specStrategy.buildRequestSpecification();
    }
}