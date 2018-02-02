package restAssured.restTest;

import com.jsystems.models.ErrorResponse;
import com.jsystems.models.MyObj;
import com.jsystems.models.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restAssured.Config;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;


public class RestTest extends Config {

    @Test
    @DisplayName("=====first test")
    public void firstTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
//                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @Test
    public void secondTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].produce", equalTo("dell"));
    }

    @Test
    public void nextTest() {
        JsonPath jsonPath = given()
                .when()
//                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        MyObj myObj = jsonPath.getObject("", MyObj.class);

        assertThat(myObj.name).isEqualTo("Piotr");
        assertThat(myObj.surname).isEqualTo("Kowalski");
    }

    @Test
    @DisplayName("Get/v2/5a6a58222e0000d0377a7789")
    public void usersTest() {
        JsonPath jsonPath = given()
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        List<User> users = jsonPath.getList("", User.class);

        System.out.println(users);

        assertThat(users.get(0).device.get(0).type)
                .isEqualTo("computer");

        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce)
                .isEqualTo("dell");

        assertTrue(users.get(0).device.get(0).deviceModel.get(0)
                .screen_size == 17);
    }

    @Test
    public void piatyTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .andReturn();

        System.out.println(response);

        MyObj myObj = response
                .then()
                .extract()
                .body()
                .as(MyObj.class);
        System.out.println(myObj);
        assertThat(myObj.name).isEqualTo("Piotr");
        assertThat(myObj.surname).isEqualTo("Kowalski");
    }

    @Test
    public void szostyTest() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .queryParam("name", "Piotr")
                .queryParam("surname", "Kowalski")
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        List<User> users = Arrays.asList(
                response
                        .then()
                        .extract()
                        .body()
                        .as(User[].class)
        );

        assertTrue(response.contentType().equals("application/json"));
            assertThat(users.get(0).device.get(0).type)
                    .isEqualTo("computer");
            assertThat(users.get(0).imie).isEqualTo("Piotr");
            assertThat(users.get(0).device.get(0).deviceModel.get(0).produce)
                    .isEqualTo("dell");

    }

    @Test
    public void postTest(){
        Response response = given()
                .when()
                .body(new MyObj("Rafal", "Wrobol"))
                .post("/5a690a1b2e000051007a73cb")
                .andReturn();

        String responsePostEmptyTable =
                Arrays.asList(response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class)).toString();

        assertThat(responsePostEmptyTable).isEqualTo("[]");

    }

    @Test
    public void errorTest(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .post("/5a690b452e000054007a73cd")
                .andReturn();

        ErrorResponse errorResponse = response
                .then()
                .extract()
                .body()
                .as(ErrorResponse.class);

        assertTrue(errorResponse.error.error_code == 400);
        assertThat(errorResponse.error.validation_erro)
                .isEqualTo("invalid_email");
        assertThat(errorResponse.error.message)
                .isEqualTo("your email is invalid");


    }

    @Test
    public void specBuild(){
//        RequestSpecification requestSpecification = new RequestSpecBuilder()
//                .addCookie("sdf","sadf")
//                .addHeader("Authorization", "asfeasdf7658765")
//                .setBaseUri("http://www.onet.pl")
//                .build();

        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/5a6b77973100009d211b8b0d")
                .andReturn();

        MyObj myObj = response
                .then()
                .extract()
                .body()
                .as(MyObj.class);
        assertThat(myObj.name).isEqualTo("Piotr");


    }



}
