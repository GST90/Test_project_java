package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequest {
    @Test
    public void getWithoutExtractData() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2").
                when()
                .get("/get").
                then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.foo1", equalTo("bar1"))
                .body("headers.x-forwarded-proto", equalTo("https"));
    }

    @Test
    public void getWithExtractData() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .param("foo1", "bar1")
                .param("foo2", "bar2").
                when()
                .get("/get").
                then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.foo1", equalTo("bar1"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .extract().response();

        System.out.println("GET REQUEST");
        String headersHost = response.path("headers.host");
        System.out.println("headersHost: " + headersHost);
        System.out.println("Response body from Get request:");
        response.prettyPrint();
    }
}