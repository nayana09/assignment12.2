import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.content;

public class yummytummyAPI {


    public static void main(String[] args){

        content payloadPojo = new content("Benni Dosa");

        //Post request
        Response responsePost = RestAssured.given().header("Content-Type","application/json" ).body(payload)
                            .when().post(System.getProperty("URI"));
        responsePost.prettyPrint();

        //Get request
        Response responseGet = RestAssured.given()
                .when().get(System.getProperty("URI"));

        responseGet.prettyPrint();


    }
}
