import static io.restassured.RestAssured.given;


import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Restassured_test {
	private static String requestBody = "{\n" +
            "  \"title\": \"TITLE\",\n" +
            "  \"body\": \"BODY\",\n" +
            "  \"userId\": \"1\" \n}";
    @BeforeClass
    public static void GetURL() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//      RestAssured.sessionId= "S31508252";
    }
   
  
    @Test (priority = 1)
    public void getRestassuredRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        AssertJUnit.assertEquals(200, response.statusCode());
        AssertJUnit.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
        System.out.println(response.jsonPath().getString("title[1]"));
    }
    
    @Test (priority = 2)
    public void getRequestQP() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then()
                .extract().response();

        AssertJUnit.assertEquals(200, response.statusCode());
        System.out.println(response.asString());
        AssertJUnit.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", response.jsonPath().getString("title"));
        AssertJUnit.assertEquals("1", response.jsonPath().getString("userId"));

    }
    @Test(priority = 3)
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        AssertJUnit.assertEquals(201, response.statusCode());
        AssertJUnit.assertEquals("TITLE", response.jsonPath().getString("title"));
        AssertJUnit.assertEquals("BODY", response.jsonPath().getString("body"));
        AssertJUnit.assertEquals("1", response.jsonPath().getString("userId"));
        AssertJUnit.assertEquals("101", response.jsonPath().getString("id"));
    }
    // Negative test to assert on non existing property key
    @Test
    public void NegativeTest() {
    	  Response response = given()
                  .contentType(ContentType.JSON)
                  .when()
                  .get("/posts")
                  .then()
                  .extract().response();

          AssertJUnit.assertEquals(200, response.statusCode());
          AssertJUnit.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }
}
