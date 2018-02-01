package restAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Config {



    @BeforeEach
    public void before(){
        System.out.println("=========@BeforeEach Rest Assured test ====");
    }

    @BeforeAll
    public static void setUp(){
        System.out.println("===== @BeforeAll RestAssured test");
        RestAssured.baseURI = DataTest.baseUri;
        RestAssured.basePath = DataTest.basePath;
    }
}
