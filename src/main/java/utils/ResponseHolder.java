package utils;


import io.restassured.response.Response;

public class ResponseHolder {

    private Response response;

    public ResponseHolder() {
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}