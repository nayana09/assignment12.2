import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseClass {

    @BeforeTest
    public void setup(){
        Properties prop = new Properties();
        RestAssured.baseURI = System.getProperty("URI");
        RestAssured.baseURI = System.getProperty("getendpoint");

    }
}
