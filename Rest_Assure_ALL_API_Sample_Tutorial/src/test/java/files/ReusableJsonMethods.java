package files;

import io.restassured.path.json.JsonPath;

//Reusable method for parsing Raw response data to Json

public class ReusableJsonMethods {

	public static JsonPath rawToJson(String response) {

		JsonPath jsp = new JsonPath(response);

		return jsp;

	}

}
