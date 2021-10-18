import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.content;

public class yummytummyjson {


    public static void main(String[] args){
        content payloadPojo = new content("Benni Dosa");

        //Post request
        Response responsePost = RestAssured.given().header("Content-Type","application/json" ).body(payload)
                .when().post(System.getProperty("URI"));
        responsePost.prettyPrint();

        //Getting id
        JsonPath jp = new JsonPath( responsePost.prettyPrint());
        int id = jp.getInt("id");
        System.out.println("id of the order is: "+id);

        //getting date
        String dateAdded = jp.getString("date_added");
        System.out.println("Ordered Date is: "+dateAdded);

        //getting Content
        String content = jp.getString("content");
        System.out.println("What you ordered: "+content);

        //Get request
        Response responseGet = RestAssured.given()
                .when().get(System.getProperty("URI") + id );

        responseGet.prettyPrint();


    }
}
