package restassured;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.Header;
import io.restassured.http.Headers;

//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.then;
import static io.restassured.RestAssured.*;
//import io.restassured.specification.ResquestSpecification;
public class PostmanApiTest {
	public static void main(String[] args) throws IOException {
		PostmanCollection postmanCollection;
		try {
			File myObj = new File("D:\\postman collection\\Postman Collections\\Automation Test.postman_collection.json");
			Scanner myReader = new Scanner(myObj);
			String data = myReader.nextLine();
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();
		
			}
//			System.out.println(data);
			myReader.close();
			
			postmanCollection = Converter.fromJsonString(data);
			
			
			 for (Item item: postmanCollection.getItem()) {
				 ObjectMapper mapper = new ObjectMapper();
				 if (item.getRequest().getMethod().equals("GET") ) {
//					 get("/events?id=390").then().statusCode(200).assertThat()
//				      .body("data.leagueId", equalTo(35));
					 with()
				      .when()
				      .request(item.getRequest().getMethod(), item.getRequest().getURL())
				      .then()
				      .statusCode(200);
					 
				 }
				 else {
					 List<Header> headers = new ArrayList<Header>();
					 for (PostmanHeader header : item.getRequest().getHeader()) {
						 headers.add(new Header(header.getKey(), header.getValue()));
					 }
					 Headers requestHeaders = new Headers(headers);
//					  post("",)
					  with().body(mapper.writeValueAsString(item.getRequest().getBody())).headers(requestHeaders)
				      .when()
				      .request(item.getRequest().getMethod(), item.getRequest().getURL())
				      .then()
				      .statusCode(201);
//				 Response response = httpRequest.post("");
				 
				 // Get the status code from the Response. In case of 
				 // a successfull interaction with the web service, we
				 // should get a status code of 200.
//				 int statusCode = response.getStatusCode();
				 
				 // Assert that correct status code is returned.
//				 Assert.assertEquals("Correct status code returned"statusCode /*actual value*/, 200 /*expected value*/);
			 }
			 }
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		 
	}
}
