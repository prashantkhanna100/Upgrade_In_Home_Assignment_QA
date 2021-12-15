package General;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

/**
 * This class contains all the wrapper methods to call Get, Post, Update, Delete methods based on different parameters
 */
public class APIHelper {

    /**
     * This method will call the POST API and return Response
     *
     * @param Url
     * @param headers
     * @param body
     * @return
     */
    public Response postCall(String Url, HashMap<String, String> headers, String body) {
        RestAssured.baseURI = Url;
        Response response = RestAssured.given()
                .headers(headers)
                .body(body)
                .post("")
                .then().extract().response();
        return response;
    }
}
