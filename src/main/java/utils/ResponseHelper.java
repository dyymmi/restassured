package utils;


import io.restassured.response.Response;

import static io.restassured.path.json.JsonPath.from;

public class ResponseHelper {

    public static <T> T getObjectFromResponseForSpecificKeyName(Response response, String keyName, Class<T> objectType) {
        return from(response.asString()).getObject(keyName, objectType);
    }

    public static <T> T getObjectFromResponse(Response response, Class<T> objectType) {
        return response.then().extract().as(objectType);
    }
}