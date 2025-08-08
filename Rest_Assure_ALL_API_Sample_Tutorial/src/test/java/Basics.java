import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import files.ReusableJsonMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		// Creat Place API
		// validate if Add Place API is working as expected

		// given - all input details
		// when - Submit the API
		// Then - validate the response

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payLoad.bodypayload())
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String placeid=js.get("place_id");
		
		System.out.println(placeid);
		
		
		//Update Place API
		
		String address="70 Summer walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
		body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").
		when().put("maps/api/place/update/json").then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//Read the API
		
		Map<String, String> map=new HashMap();
		
		map.put("key", "qaclick123");
		map.put("place_id", placeid);
		
		String responseget=given().log().all().queryParams(map).
		when().get("maps/api/place/get/json").
		then().log().all().statusCode(200).extract().response().asString();
		
				
		JsonPath js1=ReusableJsonMethods.rawToJson(responseget );
		String addressres=js1.get("address");
		System.out.println(addressres);
		Assert.assertEquals(addressres, address);

	}
	

}
