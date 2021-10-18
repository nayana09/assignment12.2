import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.content;

import javax.swing.text.AbstractDocument;

public class TestScenarios extends BaseClass{

    @Test
    public void yummyTummyPostCall(){
        content payloadPojo = new content("Benni Dosa");

        //Post request
        Response responsePost = RestAssured.given().header("Content-Type","application/json" ).body(payloadPojo)
                .when().post(System.getProperty("URI"))
                ;

        //Getting id
        JsonPath jp = new JsonPath( responsePost.prettyPrint());
        int id = jp.getInt("id");
        String content = jp.getString("content");

        System.out.println("id of the order is: "+id);
        Assert.assertEquals(responsePost.getStatusCode(),200,"Expected status code is not marching  ");
        Assert.assertEquals(content,"Benni Dosa","Contents are not matching");
        Assert.assertNotNull(id);
    }
    @Test
    public void yummyTummyGetCall(){
        content payloadPojo = new content("Benni Dosa");
        //Post request
        Response responsePost = RestAssured.given().header("Content-Type","application/json" ).body(payloadPojo)
                .when().post(System.getProperty("URI"));

        //Getting id
        JsonPath jp = new JsonPath( responsePost.prettyPrint());
        int id = jp.getInt("id");
        System.out.println("id of the order is: "+id);


        //Get request
        Response responseGet = RestAssured.given()
                .when().get(System.getProperty("URI"));

        responseGet.prettyPrint();
        Assert.assertEquals(responsePost.getStatusCode(),200,"Expected status code is not marching  ");
        Assert.assertNotNull(id);
    }

    @Test
    public void reqresQueryParamTest(){
        Response response = RestAssured.given().queryParam("page", 5).when().get(System.getProperty("getendpoint"));
        response.prettyPrint();

    }

    @Test
    public void yummyTummyPathParameter(){
        Response responseGet = RestAssured.given().pathParam("id",1)
                .when().get("{id}");
        responseGet.prettyPrint();
    }
}
