package restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Config {

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
//                .addCookie("sdf","sadf")
//            .addHeader("Authorization", "asfeasdf7658765")
//            .setBaseUri("http://www.onet.pl")
            .setContentType(ContentType.JSON)
            .build();


    @BeforeEach
    public void before() {
        System.out.println("=========@BeforeEach Rest Assured test ====");
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("===== @BeforeAll RestAssured test");
        RestAssured.baseURI = DataTest.baseUri;
        RestAssured.basePath = DataTest.basePath;
    }
}
